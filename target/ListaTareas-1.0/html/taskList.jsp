<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Tarea"%>
<%@page import="Datos.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta http-equiv="x-ua-compatible" content="ie=edge" />
        <title>Mi lista</title>
        <!-- MDB icon -->
        <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
        <!-- Google Fonts Roboto -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" />
        <!-- MDB -->
        <link rel="stylesheet" href="../css/bootstrap-to-do-list.min.css"/>
        <link rel="stylesheet" href="../css/tareas.css"/>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>

    <!-- Background color style :D -->
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
    <%
        String username = session.getAttribute("username").toString();
        int id_user = UsuarioDao.getID(username);
    %>

    <body class = "gradient-custom-2">

        <div>

            <!-- FORM PARA AÑADIR LAS TAREAS -->
            <section class="vh-100">
                <div class="container py-5 h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col col-lg-9 col-xl-7">
                            <div class="card rounded-3" style="background-color: #262626;">
                                <div class="card-body p-4" style="color: #262626;">

                                    <h4 class="text-center my-3 pb-3" style="color: #fff; padding: 0 !important; margin-bottom: 12px !important;">Lista de Tareas</h4>
                                    <p class="text-center my-3 pb-3" style="color: #fff; font-size: 12px; margin-top: 0px !important;"> La prioridad de la tarea es un numero entre 0 y 100</p>
                                    <form name="taskForm" action = "RegistrarTarea" method="post" class="row row-cols-lg-auto g-3 justify-content-center align-items-center mb-4 pb-2">
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

                                        <!--INPUT CREADO PARA PODER LLEVAR EL ID DEL USUARIO EN EL REQUEST ( ¿MALA PRACTICA? ¿ES MEJOR GUARDARLO EN UN OBJETO SESSION?)-->
                                        <input type="text" id="form1" name="idOwner" value="<%=id_user%>" hidden="true"/>
                                        <div class="col-12">
                                            <button id = "zzz" type="submit" class="btn btn-outline-primary">Guardar</button>
                                        </div>
                                    </form>

                                    <table class="table mb-4">
                                        <thead>
                                            <tr>
                                                <th scope="col">Prioridad</th>
                                                <th scope="col">Tarea</th>
                                                <th scope="col">Opciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- inicio del for que lista las tareas -->
                                            <%
                                                ArrayList<Tarea> tareas = UsuarioDao.getTareas(id_user);
                                                for (int i = 0; i < tareas.size(); i++) {
                                                    Tarea aux = tareas.get(i);
                                                    String msg = "", clase = "";
                                                    int prio = aux.getPrioridad();
                                                    if (prio >= 0 && prio <= 33) {
                                                        msg = "Baja";
                                                        clase = "badge badge-success";
                                                    } else if (prio >= 34 && prio <= 67) {
                                                        msg = "Media";
                                                        clase = "badge badge-warning";
                                                    } else {
                                                        msg = "Alta";
                                                        clase = "badge badge-danger";
                                                    }
                                            %>
                                            <tr>
                                                <td scope="row"><span class="<%=clase%>"><%=msg%></span></td>
                                                <td><%=aux.getTitulo()%></td>
                                                <td>
                                                    <button type="submit" class="btn btn-outline-warning" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" id = "<%=aux.getId()%>">
                                                        Editar
                                                    </button>
                                                    <button type="submit" class="btn btn-outline-danger ms-1">Eliminar</button>
                                                </td>
                                            </tr>
                                            <% }%> 
                                            <!-- CIERRE DEL FOR DE TAREAS -->
                                        </tbody>
                                    </table>
                                    <!-- un modal de prueba -->
                                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Editar Tarea</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <form>
                                                        <div class="form-group">
                                                            <label for="message-text" class="col-form-label" style="color : #000 !important;">Titulo de la Tarea</label>
                                                            <input type="text" class="form-control" id="recipient-name" style="color : #000 !important;">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="message-text" class="col-form-label" style="color : #000 !important;">Prioridad</label>
                                                            <input type="text" class="form-control" id="recipient-name" style="color : #000 !important;">
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                                    <button type="submit" class="btn btn-primary">Confirmar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <-- end proof modal -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

        <!-- Script para validar la data del form de la tarea -->
        <script>
            const btnSubmit = document.getElementById('zzz');
            btnSubmit.addEventListener('click', async (e) => {
                e.preventDefault()
                const titulo = document.forms["taskForm"]["titulo"].value;
                const prioridad = document.forms["taskForm"]["prioridad"].value;
                const nPrio = parseInt(prioridad);
                console.log(typeof nPrio);
                console.log(nPrio);

                //VALIDAMOS QUE EL TITULO NO SEA VACIO
                if (titulo.trim() == "") {
                    swal("Oops", "El titulo de tu tarea no puede estar vacio", "error");
                    return;
                }
                //VALIDAMOS LA PRIORIDAD
                if (isNaN(nPrio)) {
                    swal("Oops", "La prioridad de la Tarea debe ser numerica", "error");
                    return;
                }
                if (nPrio < 0 || nPrio > 100) {
                    swal("Oops", "La prioridad de la Tarea debe ser entre 0 y 100", "error");
                    return;
                }
                await swal("Bien Hecho", "Tu tarea se ha registrado Correctamente", "success")
                        .then(( ) => {
                            document.forms["taskForm"].submit();
                        });
            })
        </script> 

        <script>
            $('#exampleModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget) // Button that triggered the modal
                var recipient = button.data('whatever') // Extract info from data-* attributes
                // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
                // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
                var modal = $(this)
                modal.find('.modal-title').text('New message to ' + recipient)
                modal.find('.modal-body input').val(recipient)
            })
        </script>
        <!-- <script type="module" src="../js/proof.js"></script> -->
        <script type="text/javascript" src="../js/mdb.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>