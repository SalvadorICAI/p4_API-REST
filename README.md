# Práctica 4 – API REST: Intercambios en EE.UU

Este proyecto implementa una API REST en Java con Spring Boot y una página web informativa sobre intercambios a EE.UU. La API permite enviar, listar, editar y eliminar mensajes enviados por los usuarios.

---

## 📁 Estructura del proyecto

- `src/main/java/.../ControladorRest.java` → API REST con endpoints CRUD
- `src/main/java/.../ModeloMensaje.java` → Modelo de datos `Mensaje`
- Web separada también publicada en [GitHub Pages](https://salvadoricai.github.io/p4_web/) 

---

## 🌐 Página web

Hay 2 formas de ver la web:

### ✅ 1. Desde GitHub Pages (visual solamente)
[https://salvadoricai.github.io/p4_web/](https://salvadoricai.github.io/p4_web/)

> **⚠️ Esta versión no permite enviar mensajes porque el backend está en `localhost`**

---

### ✅ 2. Desde local (funcional con backend)

1. Abre `contacto.html` directamente desde el explorador de archivos (doble clic)  

## ⚙️ FUNCIONAMIENTO

- En la sección de CONTACTO de la página web, se podrán enviar los mensajes al servidor. 
- En la sección mensajes, se cargarán los distintos mensajes que se han enviado.
- Cuando se muestren los mensajes, se podrán eliminar y editar tanto el correo electrónico y el menasje 
