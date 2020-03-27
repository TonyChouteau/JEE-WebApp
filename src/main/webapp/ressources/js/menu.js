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
		let sep = (elt.name === "Current")?'<div class="verticalSeparator"></div>':"";

		return sep+`
			<a href="`+elt.href+`" class="menu-item `+(elt.admin?"menu-admin":"")+`">
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

	let menu = [{
			"name" : "Games",
			"href" : "/home",
			"img"  : "/ressources/img/baseline_view_list_black_18dp.png",
			"admin" : false,
		}
	]

	if (logged){
		menu.push(...[{
				"name" : "My profile",
				"href" : "/player",
				"img"  : "/ressources/img/baseline_account_circle_black_18dp.png",
				"admin" : false,
			},{
				"name" : "Log out",
				"href" : "/signout",
				"img"  : "/ressources/img/baseline_power_settings_new_black_18dp.png",
				"admin" : false,
			}
		]);
	}
	if (admin){
		menu.push(...[{
				"name" : "Current",
				"href" : "/currentGames",
				"img"  : "/ressources/img/baseline_play_arrow_black_18dp.png",
				"admin" : true,
			},{
				"name" : "Past",
				"href" : "/pastGames",
				"img"  : "/ressources/img/baseline_fast_rewind_black_18dp.png",
				"admin" : true,
			},{
				"name" : "Players",
				"href" : "/listPlayers",
				"img"  : "/ressources/img/baseline_people_black_18dp.png",
				"admin" : true,
			},{
				"name" : "Games",
				"href" : "/games",
				"img"  : "/ressources/img/baseline_library_add_check_black_18dp.png",
				"admin" : true,
		}]);
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