function drawCoordinateSystem() {
    var coordinateCanvas = document.getElementById('coordinateCanvas');

    // Ändere die Breite und Höhe des Koordinaten-Canvas auf die des Haupt-Canvas
    coordinateCanvas.width = canvas.clientWidth;
    coordinateCanvas.height = canvas.clientHeight;

    // Bestimme die Position und Größe des Canvas-Bereichs
    var canvasRect = canvas.getBoundingClientRect();

    // Zeichne das Koordinatensystem auf dem Koordinaten-Canvas
    var context = coordinateCanvas.getContext('2d');
    context.translate(0.5, 0.5);
    context.moveTo(0, canvasRect.height / 2);
    context.lineTo(canvasRect.width, canvasRect.height / 2);
    context.moveTo(canvasRect.width / 2, 0);
    context.lineTo(canvasRect.width / 2, canvasRect.height);
    context.lineWidth = 2;
    context.strokeStyle = '#000';
    context.stroke();


   // Beschriftungen zeichnen
    context.font = '12px Arial';
    context.fillStyle = '#000';

// Achsenbeschriftungen für X-Achse
    for (let i = -10; i <= 10; i += 2) {
         if (i==0){
            continue;
        }
        let x = additionalCanvas.width / 2 + i * 20; // Hier kannst du den Abstand anpassen
        context.fillText(i.toString(), x - 5, additionalCanvas.height / 2 + 15);
    }

    // Achsenbeschriftungen für Y-Achse
    for (let i = -10; i <= 10; i += 2) {
        if (i==0){
            continue;
        }
        let y = additionalCanvas.height / 2 - i * 20; // Hier kannst du den Abstand anpassen
        context.fillText(i.toString(), additionalCanvas.width / 2 + 10, y + 5);
    }

    context.fillText('0', additionalCanvas.width / 2 - 10, additionalCanvas.height / 2 + 15);
    context.fillText('X', additionalCanvas.width - 10, additionalCanvas.height / 2 + 15);
    context.fillText('-X', 10, additionalCanvas.height / 2 + 15);
    context.fillText('Y', additionalCanvas.width / 2 + 10, 15);
    context.fillText('-Y', additionalCanvas.width / 2 + 10, additionalCanvas.height - 5);
}