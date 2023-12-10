// Variable zum Speichern der generierten HTML-Inhalte
var generatedHTML = "";

function createLevels(numLevels) {

    var levelsContainer = document.getElementById("levelsContainer");

    levelsContainer.style = "margin: 100px"

    levelsContainer.appendChild(createTitle("H1", "Deine Coding-Ergebnisse"))

    for (var i = 0; i < numLevels; i++) {
        var levelContainer = createContainer("level" + i);
        var exerciseContainer = createContainer("level" + i + "_exercise");
        var codeContainer = createContainer("level" + i + "_code");
        var canvasContainer = createContainer("level" + i + "_canvas_container");

        levelContainer.appendChild(createTitle("H2", "Level " + i))
        levelContainer.appendChild(createTitle("H3", "Aufgabenstellung und Hinweise"))
        levelContainer.appendChild(exerciseContainer);
        levelContainer.appendChild(createTitle("H3", "Dein Code"))
        levelContainer.appendChild(codeContainer);
        levelContainer.appendChild(createTitle("H3", "Canvas"))
        levelContainer.appendChild(canvasContainer);

        // getExercise(i, exerciseContainer) // später in Brython einfügen

        if (i == 0) {
            levelContainer.style = "margin-top: 100px"
        }

        levelContainer.style = "margin-bottom: 100px"

        levelsContainer.appendChild(levelContainer);
    }

    generatedHTML = levelsContainer.outerHTML;
}

// function getExercise(level, exerciseContainer) {
//     fetch("/levels/level_" + level + ".py")
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error(`Network response was not ok: ${response.status} ${response.statusText}`);
//             }
//             return response.text();
//         })
//         .then(tutorial_str => {
//             const startMarker = 'tutorial = "';
//             const endMarker = '"\ninit_code';

//             const startIndex = tutorial_str.indexOf(startMarker) + startMarker.length;
//             const endIndex = tutorial_str.lastIndexOf(endMarker);

//             const mySubString = tutorial_str.substring(startIndex, endIndex);
            
//             exerciseContainer.html = mySubString
//         })
//         .catch(error => {
//             console.error('Fetch error:', error);
//         });
// }

function createTitle(elementType, text) {
    var title = document.createElement(elementType)
    title.innerText = text
    return title
}

function createContainer(id) {
    var container = document.createElement("div");
    container.id = id;
    return container;
}

function editExport(level) {
    var levelsContainer = document.getElementById("levelsContainer");

    var levelContainer = document.getElementById("level" + level)
    levelContainer.style = "margin-bottom: 0"

    var exerciseContainer = document.getElementById("level" + level + "_exercise");
    var codeContainer = document.getElementById("level" + level + "_code");
    var canvasContainer = document.getElementById("level" + level + "_canvas_container");

    var tutorial = document.getElementById("tutorial")
    var canvas = document.getElementById("canvas")

    exerciseContainer.innerHTML = tutorial.innerHTML

    addCode(codeContainer)

    canvasContainer.innerHTML = canvas.innerHTML
    renameAnimationIds(canvasContainer.id, "turtle-canvas", level)

    generatedHTML = levelsContainer.outerHTML;
}

function addCode(codeContainer) {
    var preElement = document.createElement("pre");
    preElement.classList.add("pre-block");

    var codeElement = document.createElement("code");
    codeElement.classList.add("code-block");

    codeElement.textContent = editor.getValue();

    preElement.appendChild(codeElement);

    codeContainer.appendChild(preElement);

    codeContainer.style = "height: max-content"
}

function renameAnimationIds(canvasContainerId, svgId, level) {
    var svg = document.querySelector("#" + canvasContainerId + " > #" + svgId);

    svg.querySelectorAll('[id^="animation_frame"]').forEach(function (element) {
        var currentId = element.id
        var frameNumber = currentId.match(/\d+/)[0];
        var newId = 'level' + level + '_animation_frame' + frameNumber

        element.id = newId;

        svg.querySelectorAll('[begin="' + currentId + '.end"]').forEach(function (element) {
            element.setAttribute('begin', newId + '.end')
        });
    });

    svg.id = svg.id + "-" + level
}

document.addEventListener('DOMContentLoaded', () => {
    createLevels(6);
});

function exportDownload() {
    createHTML(downloadHTML);
}

function exportPrint() {
    createHTML(printHTML);
}

function exportUpload() {
    createHTML(uploadHTML);
}

function downloadHTML(htmlContent) {
    var blob = new Blob([htmlContent], { type: 'text/html' });
    var link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = 'exported.html';
    link.click();
}

function printHTML(htmlContent) {
    // Hier könntest du den HTML-Content drucken
    var iframe = document.createElement('iframe');
    iframe.style.display = 'none';
    iframe.srcdoc = htmlContent;

    document.body.appendChild(iframe);

    iframe.onload = function () {
        iframe.contentWindow.print();
        document.body.removeChild(iframe);
    };
}

function uploadHTML(htmlContent) {
    // Hier könntest du den HTML-Content hochladen
    // Implementiere diese Funktion nach Bedarf
    // Beachte, dass das direkte Hochladen von HTML-Dateien auf einigen Plattformen eingeschränkt sein kann
    console.log(htmlContent);
}

function createHTML(callbackFunction) {
    // Hier wird der HTML-Code des versteckten Elements extrahiert
    var htmlContent = document.getElementById('levelsContainer').outerHTML;

    // Du kannst den HTML-Content weiterverarbeiten oder modifizieren, falls notwendig
    htmlContent = htmlContent.replace('hidden=""', '');

    // Rufe die exportierende Funktion mit dem HTML-Content auf
    callbackFunction(htmlContent);
}