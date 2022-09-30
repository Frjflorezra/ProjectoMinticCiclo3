import swal from 'https://unpkg.com/sweetalert/dist/sweetalert.min.js';

function validarDatos(titulo , prioridad){
    const nPrio = parseInt( prioridad );
    //VALIDAMOS QUE EL TITULO NO SEA VACIO
    if(titulo.trim() == "") {
        swal("Oops", "El titulo de tu tarea no puede estar vacio", "error");
        return false;
    }
    //VALIDAMOS LA PRIORIDAD
    if( isNaN(nPrio) ){
        swal ( "Oops" ,  "La prioridad de la Tarea debe ser numerica" ,  "error" );
        return false;
    }
    if(0 < nPrio || nPrio > 100){
        swal ( "Oops" ,  "La prioridad de la Tarea debe ser entre 0 y 100" ,  "error" );
        return false;
    }
    swal("Bien Hecho", "Tu tarea se ha registrado Correctamente", "success");
    return true;
}