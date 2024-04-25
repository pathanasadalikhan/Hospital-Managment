<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Appointment Confirmation</title>
    <!-- Bootstrap CDN for styling -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .confirmation-container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div class="container confirmation-container">
        <h2 class="mb-4">Appointment Confirmation</h2>
        <div class="row">
            <div class="col-md-6">
                <p><strong>Patient Name:</strong> ${name}</p>
                <p><strong>Age:</strong> ${age}</p>
                <p><strong>Medical Condition:</strong> ${medicalCondition}</p>
            </div>
            <div class="col-md-6">
                <p><strong>Doctor:</strong> ${doctor}</p>
                <p><strong>Date:</strong> ${date}</p>
                <p><strong>Time:</strong> ${time}</p>
            </div>
        </div>
        <hr>
        <p class="text-muted">Thank you for booking your appointment!</p>
    </div>
    <script>
        setTimeout(function(){
            window.location.href = "/HospitalProject/NewFile.html";
        }, 10000);
    </script>
</body>
</html>