// Mostrar el formulario para agregar un camión
function mostrarFormularioCamion() {
    document.getElementById('formulario-camion').style.display = 'block';
}

// Agregar un camión
function agregarCamion() {
    const patente = document.getElementById('patente').value;
    const marca = document.getElementById('marca').value;
    const modelo = document.getElementById('modelo').value;
    const ciudad = document.getElementById('ciudad').value;
    const flota = document.getElementById('flota').value;

    const camion = {
        patente,
        marca,
        modelo,
        ciudad,
        flota
    };

    fetch('/camiones', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(camion)
    })
    .then(response => response.json())
    .then(data => {
        alert('Camión agregado');
        listarCamiones();  // Refrescar la lista de camiones
    })
    .catch(error => console.error('Error:', error));
}

// Listar los camiones
function listarCamiones() {
    fetch('/camiones')
        .then(response => response.json())
        .then(camiones => {
            const lista = document.getElementById('lista-camiones');
            lista.innerHTML = '';
            camiones.forEach(camion => {
                const li = document.createElement('li');
                li.innerHTML = `${camion.patente} - ${camion.marca} - ${camion.modelo}`;
                const btnEliminar = document.createElement('button');
                btnEliminar.innerText = 'Eliminar';
                btnEliminar.onclick = function() { eliminarCamion(camion.id) };
                li.appendChild(btnEliminar);
                lista.appendChild(li);
            });
        });
}

// Eliminar un camión
function eliminarCamion(id) {
    fetch(`/camiones/${id}`, {
        method: 'DELETE'
    })
    .then(response => response.json())
    .then(() => {
        alert('Camión eliminado');
        listarCamiones();  // Refrescar la lista de camiones
    })
    .catch(error => console.error('Error:', error));
}

// Agregar paquete
function agregarPaquete() {
    const origen = document.getElementById('origen').value;
    const destino = document.getElementById('destino').value;
    const fragil = document.getElementById('fragil').checked;
    const dniRemitente = document.getElementById('dni-remitente').value;
    const dniDestinatario = document.getElementById('dni-destinatario').value;

    const paquete = {
        origen,
        destino,
        fragil,
        dniRemitente,
        dniDestinatario
    };

    fetch('/paquetes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(paquete)
    })
    .then(response => response.json())
    .then(data => {
        alert('Paquete agregado');
        listarPaquetes();  // Refrescar la lista de paquetes
    })
    .catch(error => console.error('Error:', error));
}

// Listar paquetes
function listarPaquetes() {
    fetch('/paquetes')
        .then(response => response.json())
        .then(paquetes => {
            const lista = document.getElementById('lista-paquetes');
            lista.innerHTML = '';
            paquetes.forEach(paquete => {
                const li = document.createElement('li');
                li.innerHTML = `${paquete.origen} - ${paquete.destino}`;
                lista.appendChild(li);
            });
        });
}

// Llamar a listarCamiones y listarPaquetes cuando cargue la página
window.onload = function() {
    listarCamiones();
    listarPaquetes();
};