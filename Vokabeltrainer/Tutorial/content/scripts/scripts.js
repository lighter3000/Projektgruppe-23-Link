// script.js
var currentStep = 1;
var totalSteps = 3;

function updateStepIndicator() {
    document.getElementById('stepIndicator').textContent = 'Step ' + currentStep + ' / ' + totalSteps;

    // Update the header title based on the current step
    var headerTitle = document.getElementById('headerTitle');
    var currentStepContainer = document.getElementById('step' + currentStep);

    // Check if the current step container and its data-title attribute exist
    if (currentStepContainer && currentStepContainer.dataset.title) {
        headerTitle.textContent = currentStepContainer.dataset.title;
    }
}

function updateButtonsVisibility() {
    document.getElementById('prevBtn').style.display = (currentStep > 1) ? 'block' : 'none';
    document.getElementById('nextBtn').style.display = (currentStep < totalSteps) ? 'block' : 'none';
}

function nextStep() {
    if (currentStep < totalSteps) {
        document.getElementById('step' + currentStep).style.display = 'none';
        currentStep++;
        document.getElementById('step' + currentStep).style.display = 'block';
        updateStepIndicator();
        updateButtonsVisibility();
    }
}

function prevStep() {
    if (currentStep > 1) {
        document.getElementById('step' + currentStep).style.display = 'none';
        currentStep--;
        document.getElementById('step' + currentStep).style.display = 'block';
        updateStepIndicator();
        updateButtonsVisibility();
    }
}

function toggleSolution(solutionId) {
    var solution = document.getElementById(solutionId);
    solution.style.display = (solution.style.display === 'none') ? 'block' : 'none';
}

function toggleHint(hintId) {
    var hint = document.getElementById(hintId);
    hint.style.display = (hint.style.display === 'none') ? 'block' : 'none';
}

function openModal(imageSrc) {
    var modal = document.getElementById('myModal');
    var fullSizeImage = document.getElementById('fullSizeImage');
    fullSizeImage.src = imageSrc;
    modal.style.display = 'block';

    // Close the modal if clicked outside the image
    window.onclick = function(event) {
        if (event.target == modal) {
            closeModal();
        }
    };
}

function closeModal() {
    var modal = document.getElementById('myModal');
    modal.style.display = 'none';
    window.onclick = null; // Remove the onclick event when modal is closed
}

// Initial update of step indicator and buttons visibility
updateStepIndicator();
updateButtonsVisibility();
