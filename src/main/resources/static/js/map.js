async function initMap() {
    // Request needed libraries.
    const {Map} = await google.maps.importLibrary("maps");
    const myLatlng = {lat: 38.003247869760045, lng: 23.755245199919635};
    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 10,
        center: myLatlng,
    });
    // Create the initial InfoWindow.
    let infoWindow = new google.maps.InfoWindow({
        content: "Click the map to get Lat/Lng!",
        position: myLatlng,
    });

    infoWindow.open(map);

    // Configure the click listener.
    map.addListener("click", (mapsMouseEvent) => {
        // Close the current InfoWindow.
        infoWindow.close();
        // Create a new InfoWindow.
        infoWindow = new google.maps.InfoWindow({
            position: mapsMouseEvent.latLng,
        });
        // Save coordinates as JSON
        var coordJSON = JSON.stringify(mapsMouseEvent.latLng.toJSON());
        const coord = JSON.parse(coordJSON);
        // alert(document.querySelector("#pharmlat").value)
        // alert(document.querySelector("#pharmlng").value)
        document.querySelector("#pharmlat").value = coord.lat;
        document.querySelector("#pharmlng").value = coord.lng;
    });
}

initMap();