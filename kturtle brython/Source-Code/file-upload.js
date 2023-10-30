function uploadFile() {

    var filePath = 'test_upload_file.txt';

    var linkToDownload = document.getElementById("linkToDownload")
    var qrCodeToDownload = document.getElementById("qrCodeToDownload")

    fetch(filePath)
        .then(response => response.blob())
        .then(blob => {
            var formData = new FormData();
            formData.append('file', blob, filePath);

            fetch('https://store1.gofile.io/uploadFile', {
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
                    }
                })
                .catch(error => {
                    console.error(error);
                });
        })
        .catch(error => {
            console.error(error);
        });
}