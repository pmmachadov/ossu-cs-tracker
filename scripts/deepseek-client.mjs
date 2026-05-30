#!/usr/bin/env node
import { searchDeepseek } from '../src/integrations/deepseek.js';

const q = process.argv[2] || 'test query';
const limit = parseInt(process.argv[3], 10) || 5;
const model = process.argv[4] || process.env.DEEPSEEK_MODEL || process.env.VITE_DEEPSEEK_MODEL;
const session_id = process.env.SESSION_ID || undefined;

(async () => {
  try {
    const res = await searchDeepseek(q, { limit, model, session_id });
    console.log(JSON.stringify(res, null, 2));
  } catch (e) {
    console.error('Deepseek error:', e.message || e);
    process.exit(1);
  }
})();
