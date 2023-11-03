function uploadFile() {

    var filePath = 'test_upload_file.txt';

    var qrcode_modal = document.getElementById("qrcodeModal")
    var linkToDownload = document.getElementById("linkToDownload")
    var qrCodeToDownload = document.getElementById("qrCodeToDownload")
    var message = document.getElementById("message")
    var errorMessage = document.getElementById("errorMessage")

    qrCodeToDownload.style.display = "none"
    linkToDownload.style.display = "none"
    errorMessage.style.display = "none"

    message.style.display = "block"
    qrcode_modal.style.display = "block"

    fetch(filePath)
        .then(response => response.blob())
        .then(blob => {
            var formData = new FormData();
            formData.append('file', blob, filePath);

            fetch('https://api.gofile.io/getServer')
                .then(response => response.json())
                .then(data => {
                    if (data.status === 'ok') {
                        fetch('https://' + data.data.server + '.gofile.io/uploadFile', {
                            method: 'POST',
                            body: formData
                        })
                            .then(response => response.json())
                            .then(data => {
                                if (data.status === 'ok') {

                                    qrCodeToDownload.innerHTML = null
                                    var qrcode = new QRCode("qrCodeToDownload")

                                    qrcode.clear()
                                    qrcode.makeCode(data.data.downloadPage);

                                    linkToDownload.href = data.data.downloadPage
                                    linkToDownload.text = data.data.downloadPage

                                    qrCodeToDownload.style.display = "block"
                                    linkToDownload.style.display = "block"
                                    message.innerText = 'QR-Code scannen zum herunterladen!'
                                } else {
                                    message.style.display = "none"
                                    errorMessage.innerText = 'Error beim Upload:\n' + data.status 
                                    errorMessage.style.display = "block"
                                }
                                qrcode_modal.style.display = "block"
                            })
                            .catch(error => {
                                console.error(error);
                            });
                    } else {
                        message.style.display = "none"
                        errorMessage.innerText = 'Error beim Upload:\n' + data.status 
                        qrcode_modal.style.display = "block"
                    }
                })
                .catch(error => {
                    console.error(error)
                    message.style.display = "none"
                    errorMessage.innerText = 'Error beim Upload: keine Intrnetverbindung'
                    qrcode_modal.style.display = "block"
                })
        })
        .catch(error => {
            console.error(error);
        });
}