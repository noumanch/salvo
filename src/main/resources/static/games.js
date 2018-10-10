$.ajax({
  url: "/api/createdData",
  cache: false,
  success: function(html){
    $("#results").append(html);
    console.log(html);
    createList(html);
  }
});

function createList(data){
    var createOl = document.createElement('ol');

/*    for(let i = 0; i < data.length; i++){
        var list = document.createElement('li');
//        list.innerHTML = "test";
        list.innerHTML = data[i];
        createOl.append(list);
    }*/

    //let listElements = data.map(row => "<li>" + row.Date + "</li>").join(""); // without template literals
    let listElements = data.map(row => `<li>GameId ${ row.id } CreatedDate ${ row.Date } ${ row.gamePlayers[0].player.name } </li>`).join(""); // with template literals
    createOl.innerHTML = listElements;

    document.getElementById('myContent').append(createOl);

 }
