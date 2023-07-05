var api = "http://localhost:9090/api/customer" ;
var customerTable;

function init(){

    console.log('inside init' );

    $("#new-customer-button").click( function () {
        console.log("Inside click of new-customer-button");
        $('#customer-modal').modal('show');
    });

    $("#edit-customer-button").click( function () {
        console.log("Inside click of editCustomerButton");
        // Get the data from selected row and fill fields in modal

//        $("#name").val('XXXXX');
//        $("#address").val('ZZZZZZZZ');
//        $("#age").val(23);

        if (customerTable.row($('.selected')).data() == undefined) {
            alert("Select customer first");
        }else{
            var customer = customerTable.row($('.selected')).data();
            alert(customer.id);
            $("#id").val(customer.id);
            $("#name").val(customer.name);
            $("#address").val(customer.address);
            $("#age").val(customer.age);

            $('#customer-modal').modal('show');
        }

    });

    $("#delete-customer-button").click( function () {
        console.log("Inside click of deleteCustomerButton");

        if (customerTable.row($('.selected')).data() == undefined) {
            alert("Select customer first");
        }else{
            $('#customer-delete-modal').modal('show');
        }

    });

    // Button in modal
    $("#delete-customer-confirm-button").click( function () {
        console.log("Inside click of deleteCustomerButton");
        deleteCustomer();
        $('#customer-delete-modal').modal('hide');
    });

    // Add submit event to form for new and edit
    $("#customer-form").on('submit', function() {
        console.log("Submitting");
        createCustomer();
        $('#customer-modal').modal('hide');
    });

    initCustomerTable();
    // Get customers from backend and and update table
    getCustomerData();

}

function initCustomerTable() {

    console.log('inside initCustomerTable' );

    // Create columns (with titles) for datatable: id, name, address, age
    columns = [
        { "title":  "Customer ID",
            "data": "id" ,
            "visible": false },
        { "title":  "Name",
            "data": "name" },
        { "title":  "Address",
            "data": "address" },
        { "title": "Age",
            "data": "age"},
    ];

    // Define new table with above columns
    customerTable = $("#customerTable").DataTable( {
        "order": [[ 1, "asc" ]],
        "columns": columns
    });


    $("#customerTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
          // emptyRoomModals();
        }
        else {
            customerTable.$('tr.selected').removeClass('selected');
          // emptyRoomModals();
            $(this).addClass('selected');
        }
    });

}

function getCustomerData(){

    console.log('inside getCustomerData' );
    // http:/localhost:9090/api/customer
    // json list of customers
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        // success: function(customers, textStatus, jqXHR){
        success: function(customers){

 //           console.log('Data: ' + customers );

            if (customers) {
                customerTable.clear();
                customerTable.rows.add(customers);
                customerTable.columns.adjust().draw();
            }
        },

        fail: function (error) {
            console.log('Error: ' + error);
        }

    });

}

function createCustomer(){

    console.log('inside createCustomer' );

    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var customerData = {
            id: $("#id").val(),
            name: $("#name").val(),
            address: $("#address").val(),
            age: $("#age").val()
    }

    // Transform Javascript object to json
    var customerJson = JSON.stringify(customerData);

    console.log(customerJson);

    $.ajax({
        url: api,
        type: "post",
        data: customerJson,    // json for request body
        contentType:"application/json; charset=utf-8",   // What we send to frontend
        dataType: "json",  // get back from frontend
        // success: function(customer, textStatus, jqXHR){
        success: function(customer){

          console.log(customer);

          // Clear fields in page
          $("#id").val('');
          $("#name").val('');
          $("#address").val('');
          $("#age").val('');

          // Refresh table data
          getCustomerData();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}

function deleteCustomer(){

    if (customerTable.row($('.selected')).data() == undefined) {
        alert("Select customer first");
    }else{
        var customer = customerTable.row($('.selected')).data();

        console.log(api + '/' + customer.id);

            $.ajax({
                url: api + '/' + customer.id,
                type: "delete",
                dataType: "text",  // get back from frontend
                // success: function(customer, textStatus, jqXHR){
                success: function(message){

                  console.log(message);

                  // Refresh table data
                  getCustomerData();

                },

                fail: function (error) {
                  console.log('Error: ' + error);
                }

            });
    }
}
