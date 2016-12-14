'use strict';
var gulp = require('gulp'),
minifycss = require('gulp-minify-css'),
clean = require('gulp-clean'),
autoprefixer = require('gulp-autoprefixer'),
imagemin = require('gulp-imagemin'),
changed = require('gulp-changed'),
rename = require('gulp-rename'),
concat = require('gulp-concat'),
cache = require('gulp-cache'),
jshint = require('gulp-jshint'),
uglify = require('gulp-uglify'),
watch = require('gulp-watch'),
plumber = require('gulp-plumber'),
minhtml = require('gulp-htmlmin'),
browserSync = require('browser-sync'),
order = require("gulp-order");
//sass = require('gulp-sass');
//var browserSync = require('browser-sync').create();
//var reload = browserSync.reload;
gulp.task('clean', function() {
return gulp.src(['../webapp/dest'], {read: false})
.pipe(clean());
});

gulp.task('html',function(){
	gulp.src('./partials/*')
		.pipe(minhtml({collapseWhitespace: true}))
		.pipe(changed('./dist/html'))
		.pipe(gulp.dest('./dist/html'));
});

gulp.task('css',function(argument){
	gulp.src('./css/*')
		.pipe(plumber())
		.pipe(changed('./dist/css'))
		.pipe(concat('merge.css'))
		.pipe(rename({
			suffix: '.min'
		}))
		.pipe(minifycss())
		.pipe(gulp.dest('./dist/css/'));
});

gulp.task('js', function(argument){
	gulp.src(['./js/lib/*','./js/*'])
		.pipe(order([
			"js/lib/angular-1.2.4.js",
            "js/lib/angular-route-1.2.4.js",
			"js/lib/angular-resource-1.2.4.js",
			"js/lib/ng-table-0.3.1.js",
			"js/librarian.js",
			"js/services.js"			
		]))
		.pipe(jshint())
		.pipe(jshint.reporter('default'))
		.pipe(plumber())
		.pipe(changed('./dist/js'))
		.pipe(concat('merge.js'))
		.pipe(rename({
			suffix: '.min'
		}))
		.pipe(uglify())
		.pipe(gulp.dest('./dist/js/'));	
});

gulp.task('clear', function(){
	gulp.src(['./dist/html/*','./dist/js/*','./dist/css/*'], {read: false})
		.pipe(clean());
});

gulp.task('watch',function(){
	gulp.watch('./html/*',['html']);
})

gulp.task('build',['clear','html','css','js'])
