// insert variable for api call
var api = "/api/room" ;

// Insert vaiable for dataTable
var roomTable;

function init(){

    //assign functions to events (click, submit)

    $("#check-out-date,#persons,#cleaned,#disabled,#smoking").on('change', function() {
        getAvailableRooms();
    });

    // Add submit event to form for new and edit
    $("#check-availability").on('click', function() {
        console.log("Checking");
        getAvailableRooms();

    });
    //initialize roomTable;
    initRoomTable();
    getAllRooms();
    // refresh roomTable with data
}

function initRoomTable(){

    // Create columns (with titles) for datatable: id, name, address, age
    columns = [
        { "title":  "Reservation ID",
            "data": "id",
            "visible": false },
        { "title": "Room number",
           "data": "roomNumber" },
        { "title": "Room Type",
           "data": "roomType" },
        { "title": "Beds",
           "data": "beds" },
        { "title": "Disabled",
           "data": "disabled" },
        { "title": "Smoking",
           "data": "smoking"},
        { "title": "Seaview",
            "data": "seaView",
            "render": function(seaView) {
                if (seaView == true) {
                    return "with sea view"
                } else {
                    return "without sea view"
                }
            }},
        { "title": "Seaview",
            "data": "seaView",
            "render": function(seaView) {
                return seaViewRenderer(seaView);
        }}
    ];

    // Define new table with above columns
    roomTable = $("#room-table").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });

    $("#room-table tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
          clearDiscountData();
          // emptyRoomModals();
        }
        else {
          roomTable.$('tr.selected').removeClass('selected');
          $(this).addClass('selected');
          getDiscountData();
        }
    });

}




function seaViewRenderer( seaView){
    if (seaView == true) {
        return "with sea view"
    } else {
        return "without sea view"
    }
}

function getAllRooms(){

    $.ajax({
        url: api,
        type: "get",
        dataType: "json",  // get back from frontend
        // success: function(reservation, textStatus, jqXHR){
        success: function(rooms){

          // Refresh table data
          refreshRoomTable(rooms);

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}
function getAvailableRooms(){

    var checkInDate = $("#check-in-date").val();
    var checkOutDate = $("#check-out-date").val();
    var queryString = "?checkInDate=" + checkInDate + "&checkOutDate=" + checkOutDate

    var criteria = {
            beds: $("#persons").val(),
            cleaned: $("#cleaned").prop('checked'),
            disabled: $("#disabled").prop('checked'),
            smoking: $("#smoking").prop('checked'),
            seaView: $("#seaView").prop('checked')
        };

    var criteriaJson = JSON.stringify(criteria);
//       alert("Get available rooms " + criteriaJson);
        // get data from form
        // data -> json
        // call post backend url
        // refresh roomTable

    $.ajax({
        url: api + "/available" + queryString,
        type: "post",
        data: criteriaJson,    // json for request body
        contentType:"application/json; charset=utf-8",   // What we send to frontend
        dataType: "json",  // get back from frontend
        // success: function(reservation, textStatus, jqXHR){
        success: function(rooms){

          // Refresh table data
          refreshRoomTable(rooms);

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}

function refreshRoomTable( rooms){

    if (rooms) {
        roomTable.clear();
        roomTable.rows.add(rooms);
        roomTable.columns.adjust().draw();
    }

}