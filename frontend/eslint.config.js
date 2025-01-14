// @ts-check
const eslint = require("@eslint/js");
const tseslint = require("typescript-eslint");
const angular = require("angular-eslint");

module.exports = tseslint.config(
  {
    files: ["**/*.ts"],
    extends: [
      eslint.configs.recommended,
      ...tseslint.configs.recommended,
      ...tseslint.configs.stylistic,
      ...angular.configs.tsRecommended,
      "plugin:prettier/recommended"  // ✅ Added Prettier integration
    ],
    processor: angular.processInlineTemplates,
    plugins: ["prettier"],  // ✅ Add Prettier plugin
    rules: {
      "prettier/prettier": "error",  // ✅ Show Prettier errors as ESLint errors
      "@angular-eslint/directive-selector": [
        "error",
        {
          type: "attribute",
          prefix: "app",
          style: "camelCase",
        },
      ],
      "@angular-eslint/component-selector": [
        "error",
        {
          type: "element",
          prefix: "app",
          style: "kebab-case",
        },
      ],
    },
  },
  {
    files: ["**/*.html"],
    extends: [
      ...angular.configs.templateRecommended,
      ...angular.configs.templateAccessibility,
      "plugin:prettier/recommended"  
    ],
    plugins: ["prettier"],  
    rules: {
      "prettier/prettier": "error"  
    },
  }
);
