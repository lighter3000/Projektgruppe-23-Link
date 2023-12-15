function showCoordinates(){
    var width = document.getElementById("coordinates").clientWidth, height = document.getElementById("coordinates").clientHeight;
    document.getElementById("coordinates").innerHTML = "";
    var svg = d3.select("#coordinates").append("svg")
        .attr("width", width)
        .attr("height", height)
        .append("g");

    var xScale = d3.scaleLinear()
        .domain([-width / 2, width / 2])
        .range([0, width]);

    var yScale = d3.scaleLinear()
        .domain([-height / 2, height / 2])
        .range([height, 0]);

    var xAxis = d3.axisBottom(xScale);
    var yAxis = d3.axisLeft(yScale);

    svg.append("g")
        .attr("transform", "translate(0," + height / 2 + ")")
        .call(xAxis);

    svg.append("g")
        .attr("transform", "translate(" + width / 2 + ",0)")
        .call(yAxis);
}