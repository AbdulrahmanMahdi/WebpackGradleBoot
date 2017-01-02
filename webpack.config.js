module.exports = {
   watch: false,
   entry: [
      './src/main/javascript/index.js'
   ],
   output: {
      path: __dirname + '/build/resources/main/',
      publicPath: '/',
      filename: 'bundle.js'
   },
   module: {
      loaders: [{
         exclude: /node_modules/,
         loader: 'babel',
         query: {
            presets: ['es2015', 'stage-1']
         }
      }]
   },
   resolve: {
      extensions: ['.js']
   }
};
