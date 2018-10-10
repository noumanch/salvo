
$.ajax({
  url: "/api/game_view/" + getValueFromUrl(),
  cache: false,
  success: function(html){
    $("#results").append(html);
    console.log(html);
    db = html;
    createGrid('createTable')
    createGrid('createTableForSalvo')
    topView(html)
    getShips(html)
    getSalvo(html)
  }
});

function getValueFromUrl(){
var pathArray = window.location.search.substr(1).split('');
var secondLevelLocation = pathArray[3];
return secondLevelLocation

}

let alpha = [" ","A", "B","C","D","E","F","G","H","I","J"]
let numb = [" ",1,2,3,4,5,6,7,8,9,10]


function createGrid(id){

    var table =document.createElement('table');
    document.getElementById(id).append(table);

    for(let i=0; i < 11; i++){
        var row = document.createElement('tr');
        row.setAttribute("class", "cell");

        table.append(row);

        for(let x=0; x<11; x++){
            var col = document.createElement('td');
            col.setAttribute("class", "cell");
            col.setAttribute("id", (id +"_"+ alpha[i] + numb[x]));
            if(i==0 || x==0){
                col.innerHTML = alpha[i] + numb[x];
            }
            row.append(col);
        }
    }
}

function getShips(db){
      var Ships = db.Ships;
      var allShips = [];
      for(let i=0; i < Ships.length; i++){
         var location = Ships[i].locations;
         for(let x = 0; x <location.length; x++){
            allShips.push("createTable"+"_"+ location[x]);
            fillingGrid("createTable"+"_"+ location[x])
         }
      }
    console.log(allShips)
}

function getSalvo(db){
        var salvo = db.Salvo;
        var allSalvo = [];
        var salvoLocation;

        for(l= 0; l<salvo.length; l++){
             salvoLocation =salvo[l].locations;

            for(j=0; j<salvoLocation.length; j++){
            allSalvo.push("createTableForSalvo"+"_"+ salvoLocation[j]);
            fillingGridForSalvo("createTableForSalvo"+"_"+ salvoLocation[j])
            }
        }
        console.log(allSalvo)
}



function fillingGrid(id){
        var tableId = document.getElementById(id).style.background = "#800080"

}

function fillingGridForSalvo(id){
        var tableId = document.getElementById(id).style.background = "black"

}

function topView(db){
   var data = db.GamePlayers[0].Player;
   var data1 = db.GamePlayers[1].Player;
   var i = data + " " + "VS" + " " + data1;
   var mainDiv = document.getElementById('topView');
   var x = document.createElement('p');
   mainDiv.append(x);
   x.innerHTML = i;
};