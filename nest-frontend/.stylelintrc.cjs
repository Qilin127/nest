// @see https://stylelint.bootcss.com/

module.exports = {
  extends: [
    'stylelint-config-standard', 
    'stylelint-config-html/vue', 
    'stylelint-config-standard-scss', 
    'stylelint-config-recommended-vue/scss', 
    'stylelint-config-recess-order', 
    'stylelint-config-prettier', 
  ],
  overrides: [
    {
      files: ['**/*.(scss|css|vue|html)'],
      customSyntax: 'postcss-scss',
    },
    {
      files: ['**/*.(html|vue)'],
      customSyntax: 'postcss-html',
    },
  ],
  ignoreFiles: [
    '**/*.js',
    '**/*.jsx',
    '**/*.tsx',
    '**/*.ts',
    '**/*.json',
    '**/*.md',
    '**/*.yaml',
  ],
  /**
   * null 
   * always
   */
  rules: {
    'value-keyword-case': null, 
    'no-descending-specificity': null, 
    'function-url-quotes': 'always', 
    'no-empty-source': null, 
    'selector-class-pattern': null, 
    'property-no-unknown': null, 
    'block-opening-brace-space-before': 'always', 
    'property-no-vendor-prefix': null,
    'selector-pseudo-class-no-unknown': [
      true,
      {
        ignorePseudoClasses: ['global', 'v-deep', 'deep'], 
      },
    ],
  },
}
