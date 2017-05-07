i = 0;
function allowDrop(ev) {
	ev.preventDefault();
}

function drag(ev) {
	ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("text");

	if (ev.ctrlKey) {
		var nodeCopy = document.getElementById(data).cloneNode(true);
		nodeCopy.id = "newId" + i;
		ev.target.appendChild(nodeCopy);
		i++;

	} else {
		ev.target.appendChild(document.getElementById(data));

	}

}

function createGrid() {
	for (var i = 0; i < 256; i++) {
		$('#grid').append('<div id="div'+ i + '" ondrop="drop(event)" ondragover="allowDrop(event)" class="tile"</div>');
	}
};

$(document).ready(function(){
	
	createGrid();

	$('.tile').click(function() {
		var img = $(this).find('img');
		if (img.hasClass('north')) {
			img.attr('class', 'west');
		} else if (img.hasClass('west')) {
			img.attr('class', 'south');
		} else if (img.hasClass('south')) {
			img.attr('class', 'east');
		} else if (img.hasClass('east')) {
			img.attr('class', 'north');
		}
	});

	$('input').click(function() {
		var img = $('.active img');
		if (img.hasClass('north')) {
			img.attr('class', 'west');
		} else if (img.hasClass('west')) {
			img.attr('class', 'south');
		} else if (img.hasClass('south')) {
			img.attr('class', 'east');
		} else if (img.hasClass('east')) {
			img.attr('class', 'north');
		}
	});

	$(".tile").click(function() {
		if ($(this).hasClass('active')) {
			$(this).removeClass('active');
		} else {
			$(this).addClass('active').siblings().removeClass('active');
		}
	});	
	
});
