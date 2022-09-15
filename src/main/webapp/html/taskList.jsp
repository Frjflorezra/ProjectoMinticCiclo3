<%-- 
    Document   : taskList
    Created on : 14/09/2022, 6:58:24 p. m.
    Author     : FELIPE
--%>

<%@page import="Datos.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta http-equiv="x-ua-compatible" content="ie=edge" />
        <title>Material Design for Bootstrap</title>
        <!-- MDB icon -->
        <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
        <!-- Google Fonts Roboto -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" />
        <!-- MDB -->
        <link rel="stylesheet" href="../css/bootstrap-to-do-list.min.css"/>
        <link rel="stylesheet" href="../css/tareas.css"/>
    </head>

    <body>
        <!-- Start your project here-->
        <style>
            .gradient-custom-2 {
                /* fallback for old browsers */
                
                background: #7e40f6;

                /* Chrome 10-25, Safari 5.1-6 */
                background: -webkit-linear-gradient(to right, rgba(126, 64, 246, 1), rgba(80, 139, 252, 1));

                /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                background: linear-gradient(to right, rgba(126, 64, 246, 1), rgba(80, 139, 252, 1))
            }
        </style>
        <%= //"nombre usuario == " + session.getAttribute("nombre").toString()%>
        <%= //"username == " + session.getAttribute("username").toString()%>
        
        <div class = "gradient-custom-2">

            <!-- FORM PARA AÑADIR LAS TAREAS -->
            <section class="vh-100">
                <div class="container py-5 h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col col-lg-9 col-xl-7">
                            <div class="card rounded-3" style="background-color: #262626;">
                                <div class="card-body p-4" style="color: #262626;">

                                    <h4 class="text-center my-3 pb-3" style="color: #fff; padding: 0 !important; margin-bottom: 12px !important;">Lista de Tareas</h4>
                                    <p class="text-center my-3 pb-3" style="color: #fff; font-size: 12px; margin-top: 0px !important;"> La prioridad de la tarea es un numero entre 0 y 100</p>
                                    <form action = "RegistrarTarea" method="post" class="row row-cols-lg-auto g-3 justify-content-center align-items-center mb-4 pb-2">
                                        <div class="col-12">
                                            <div class="form-outline">
                                                <input type="text" id="form1" name ="titulo" class="form-control" style="color: #fff;"/>
                                                <label class="form-label" for="form1" style="color: #fff;">Ingresa tu tarea aqui</label>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-outline">
                                                <input type="text" id="form1" name="prioridad" class="form-control" style="color: #fff;"/>
                                                <label class="form-label" for="form1" style="color: #fff;">Prioridad de la tarea</label>
                                            </div>
                                        </div>  
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-outline-primary">Guardar</button>
                                        </div>
                                    </form>

                                    <table class="table mb-4">
                                        <thead>
                                            <tr>
                                                <th scope="col">No.</th>
                                                <th scope="col">Tarea</th>
                                                <th scope="col">Opciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <th scope="row">1</th>
                                                <td>Buy groceries for next week</td>
                                                <td>
                                                    <button type="submit" class="btn btn-outline-warning">Editar</button>
                                                    <button type="submit" class="btn btn-outline-danger ms-1">Eliminar</button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th scope="row">2</th>
                                                <td>Renew car insurance</td>
                                                <td>
                                                    <button type="submit" class="btn btn-outline-warning">Editar</button>
                                                    <button type="submit" class="btn btn-outline-danger ms-1">Eliminar</button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th scope="row">3</th>
                                                <td>Sign up for online course</td>
                                                <td>
                                                    <button type="submit" class="btn btn-outline-warning">Editar</button>
                                                    <button type="submit" class="btn btn-outline-danger ms-1">Eliminar</button>
                                                </td>
                                            </tr>                                         
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <script type="text/javascript" src="../js/mdb.min.js"></script>
    </body>
</html>