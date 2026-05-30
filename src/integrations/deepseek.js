// Lightweight Deepseek integration helper
// Reads configuration from either Node env vars (DEEPSEEK_API_URL, DEEPSEEK_API_KEY)
// or Vite env (import.meta.env.VITE_DEEPSEEK_API_URL, VITE_DEEPSEEK_API_KEY).

function getEnv(name) {
  if (typeof process !== 'undefined' && process.env && process.env[name]) return process.env[name];
  // import.meta may not be safe to reference in some environments; guard in try/catch
  try {
    if (typeof import.meta !== 'undefined' && import.meta.env && import.meta.env[name]) return import.meta.env[name];
  } catch (e) {
    // ignore
  }
  try {
    if (typeof import.meta !== 'undefined' && import.meta.env && name.startsWith('VITE_') && import.meta.env[name]) return import.meta.env[name];
  } catch (e) {
    // ignore
  }
  return undefined;
}

export async function searchDeepseek(query, opts = {}) {
  const apiUrl = getEnv('DEEPSEEK_API_URL') || getEnv('VITE_DEEPSEEK_API_URL') || 'https://api.deepseek.example';
  const apiKey = getEnv('DEEPSEEK_API_KEY') || getEnv('VITE_DEEPSEEK_API_KEY');
  const model = opts.model || getEnv('DEEPSEEK_MODEL') || getEnv('VITE_DEEPSEEK_MODEL') || 'deepseek-v4-flash';

  if (!apiKey) {
    throw new Error('Deepseek API key not set. Provide DEEPSEEK_API_KEY or VITE_DEEPSEEK_API_KEY.');
  }

  const url = `${apiUrl.replace(/\/$/, '')}/search`;
  const body = {
    model,
    q: query,
    limit: opts.limit || 10,
    // optional session id for server-side telemetry/correlation
    ...(opts.session_id ? { session_id: opts.session_id } : {}),
    // pass any additional options through
    ...(opts.params || {})
  };

  const res = await fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${apiKey}`
    },
    body: JSON.stringify(body)
  });

  const text = await res.text();
  let parsed;
  try {
    parsed = text ? JSON.parse(text) : null;
  } catch (e) {
    parsed = text;
  }

  if (!res.ok) {
    const message = parsed && parsed.error && parsed.error.message ? parsed.error.message : text || `HTTP ${res.status}`;
    const err = new Error(`Deepseek API error ${res.status}: ${message}`);
    err.status = res.status;
    err.response = parsed;
    throw err;
  }

  return parsed;
}

export default { searchDeepseek };
