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
				<div class="item-container">
					<div>
						<img src="`+elt.img+`" class="logo">
					</div>
					<div>
						`+elt.name+`
					</div>
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
				"href" : "/home",
				"img"  : "/ressources/img/baseline_view_list_black_18dp.png"
			},{
				"name" : "My profile",
				"href" : "/player",
				"img"  : "/ressources/img/baseline_account_circle_black_18dp.png",
			},{
				"name" : "Log out",
				"href" : "/signout",
				"img"  : "/ressources/img/baseline_power_settings_new_black_18dp.png",
			}
		]
	} else {
		menu = [{
				"name" : "Games",
				"href" : "/home",
				"img"  : "/ressources/img/baseline_view_list_black_18dp.png"
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