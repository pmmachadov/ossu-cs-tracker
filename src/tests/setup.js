// Mock localStorage for jsdom
if (typeof localStorage === 'undefined') {
  globalThis.localStorage = {
    _data: {},
    getItem(key) { return this._data[key] || null; },
    setItem(key, value) { this._data[key] = String(value); },
    removeItem(key) { delete this._data[key]; },
    clear() { this._data = {}; },
    get length() { return Object.keys(this._data).length; },
    key(index) { return Object.keys(this._data)[index] || null; },
  };
}
