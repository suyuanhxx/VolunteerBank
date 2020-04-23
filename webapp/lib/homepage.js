(function($) {
	"use strict";

	var currentPage = 1;

	$('document').ready(function() {
		var oldPosition = $(window).scrollTop();

		setTimeout(function() {
			$('body').append("<script type='text/javascript'>var fb_param = {};fb_param.pixel_id = '6013069976418';fb_param.value = '0.00';fb_param.currency = 'USD';(function(){  var fpw = document.createElement('script');  fpw.async = true;  fpw.src = '//connect.facebook.net/en_US/fp.js';  var ref = document.getElementsByTagName('script')[0];  ref.parentNode.insertBefore(fpw, ref);})();</script><noscript><img height='1' width='1' alt='' style='display:none' src='https://www.facebook.com/offsite_event.php?id=6013069976418&amp;value=0&amp;currency=USD' /></noscript>");
		}, 30000);

		setTimeout(function() {
			$('body').append("<script type='text/javascript'>var fb_param = {};fb_param.pixel_id = '6013069989218';fb_param.value = '0.00';fb_param.currency = 'USD';(function(){  var fpw = document.createElement('script');  fpw.async = true;  fpw.src = '//connect.facebook.net/en_US/fp.js';  var ref = document.getElementsByTagName('script')[0];  ref.parentNode.insertBefore(fpw, ref);})();</script><noscript><img height='1' width='1' alt='' style='display:none' src='https://www.facebook.com/offsite_event.php?id=6013069989218&amp;value=0&amp;currency=USD' /></noscript>");
		}, 15000);

		$(".fancybox").fancybox({
			padding: 0,
			helpers: {
				overlay: {
					locked: false
				}
			}
		});

		$('.pull-right a').addClass('animated');

		var previousLogo = null, btmenu = $('#bt-menu');

		function restoreLogo() {
			if (previousLogo == true) {
				$('.logo img.default').addClass('invisible');
				$('.logo img.alt').removeClass('invisible');	
			} else {
				$('.logo img.default').removeClass('invisible');
				$('.logo img.alt').addClass('invisible');
			}
			
		}
		$('.logo').on('click', function() {
			if (btmenu.hasClass('bt-menu-open')) {
				btmenu.removeClass('bt-menu-open');

				restoreLogo();
			} else {
				btmenu.addClass('bt-menu-open');

				window.clearInterval(animateLogo);
				animateLogo = null;

				previousLogo = !$('.logo img.alt').hasClass('invisible');

				$('.logo img.default').addClass('invisible');
				$('.logo img.alt').removeClass('invisible');
			}
			

		});
		$('.bt-overlay').on('click', function() {
			btmenu.removeClass('bt-menu-open');

			restoreLogo();
		});

		var animateLogo = setInterval(function() {
			$('.logo').addClass('tada animated');
			setTimeout(function() {
				$('.logo').removeClass('tada animated');
			}, 1000);
		}, 6500);

		$(".main").onepage_scroll({
			sectionContainer: "section",
			easing: "ease-in-out",
			animationTime: (window.innerWidth <= 780) ? 0 : 750,
			pagination: true,
			updateURL: false,
			beforeMove: function(index) {
				$(".slide").addClass('faster').removeClass('fadeIn');
				$('.header a').toggleClass('black');
				$('.logo img.default').toggleClass('invisible');
				$('.logo img.alt').toggleClass('invisible');
				$('.fa.background').toggleClass('invisible');
			},
			afterMove: function(index) {
				activateSlide();
			},
			loop: false,
			responsiveFallback: 780
		});

		$('.moveToPlans').on('click', function() {
			$(".main").moveTo(5);
			$('.logo img.default').removeClass('invisible');
			$('.logo img.alt').addClass('invisible');
			$('.fa.background').removeClass('invisible');
			$('.header a').removeClass('black');
		});

		function activateSlide(slide) {
			$('.page').each(function(index, page) {
				$(page).find('.slide').each(function(index, el) {
					(function(el, index) {
						setTimeout(function() {
							el.removeClass('faster').addClass('fadeIn');
						}, 1000 * (index+1) - 200);
					}($(el), index));
				});
			});
		}

		activateSlide(1);
		if (window.innerWidth <= 980) {
			$('.slide').addClass('fadeIn');
		}
	});
}(jQuery));