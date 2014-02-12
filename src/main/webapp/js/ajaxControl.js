$.xhrPool = [];
$.xhrPool.abortAll = function() {
    $(this).each(function(idx, jqXHR) {
        jqXHR.abort();
    });
    $.xhrPool.length = 0
};

$.ajaxSetup({
    beforeSend: function(jqXHR) {
        $.xhrPool.push(jqXHR);
    },
    complete: function(jqXHR) {
        var index = $.xhrPool.indexOf(jqXHR);
        if (index > -1) {
            $.xhrPool.splice(index, 1);
        }
    }
});

$('a#firstClick').click(function(event){
	event.preventDefault();
	
	$.get('rest/misc/halt-request-one?duration=10000');
});

$('a#cancelRequests').click(function(event){
	event.preventDefault();
	
	$.xhrPool.abortAll();
});

$('a#cancelAndAddRequest').click(function(event){
	event.preventDefault();
	
	$.xhrPool.abortAll();
	
	$.get('rest/misc/halt-request-one?duration=10000');
});