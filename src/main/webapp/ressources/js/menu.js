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


function makeMenu() {

	let menu = [
		"Games",
		"My Profile",
		"Log Out",
	]
	console.log("x")

	let content = document.getElementById("menu-panel").innerHTML;
	
	document.getElementById("menu-panel").innerHTML = `
		<h1 id="menu">
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
        </h1>
        <div class="verticalSeparator"></div>
        <h1 id="title">
            <div>
	` + content + `
            </div>
        </h1>
    `
}

console.log("x")
window.onload = makeMenu;