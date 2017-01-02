module.exports = {
   watch: false,
   devtool: "source-map",
   entry: [
      __dirname + '/src/main/javascript/index.js'
   ],
   output: {
      path: __dirname + '/build/resources/main/public/',
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
      extensions: ['', '.js']
   }
};
