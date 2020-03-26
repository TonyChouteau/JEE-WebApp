/*

<div class="menu-item">
					<div>
						Games
					</div>
				</div>
				<div class="menu-item">
					<div>
						Players
					</div>
				</div>
				<div class="menu-item">
					<div>
						Games
					</div>
				</div>

*/

function getItems(menu){
	return menu.map((elt) => {
		return `
			<a href="`+elt.href+`"  class="menu-item">
				<div>
					`+elt.name+`
				</div>
			</a>
		`
	}).join(' ')
}

function makeMenu() {

	let menu = []

	if (logged){
		menu = [{
				"name" : "Games",
				"href" : "/home"
			},{
				"name" : "My profile",
				"href" : "/player"
			},{
				"name" : "Log out",
				"href" : "/signout"
			}
		]
	} else {
		menu = [{
				"name" : "Games",
				"href" : "/home"
			}
		]
	}

	let content = document.getElementById("menu-panel").innerHTML;
	
	document.getElementById("menu-panel").innerHTML = `
		<h1 id="menu">
			` + getItems(menu) + `
        </h1>
        <div class="verticalSeparator"></div>
        <h1 id="title">
            <div>
				` + content + `
            </div>
        </h1>
    `
}

window.addEventListener("load", makeMenu, true);