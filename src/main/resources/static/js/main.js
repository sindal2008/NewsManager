var baseUrl = $('#baseUrl').attr('content');

function leaveComment(itemId) {
    $('#comment-link-' + itemId).removeClass('show');
    $('#comment-link-' + itemId).addClass('hidden');

    $('#comment-' + itemId).removeClass('hidden');
    $('#comment-' + itemId).addClass('show');
}

function sendComment(itemId) {
    var text = $('#comment-' + itemId + ' > textarea').val();
    $.ajax({
        url: baseUrl + 'comment/add',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            itemId: itemId,
            text: text
        })
    }).done(function () {
        location.reload();
    });
}

function cancelComment(itemId) {
    $('#comment-link-' + itemId).removeClass('hidden');
    $('#comment-link-' + itemId).addClass('show');

    $('#comment-' + itemId).removeClass('show');
    $('#comment-' + itemId).addClass('hidden');
}