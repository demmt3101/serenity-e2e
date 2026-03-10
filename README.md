# 🚀 Serenity E2E - Intermediate

## 📌 Descripción

Este branch contiene la solución del ejercicio **intermediate** usando **SerenityBDD + Cucumber + Selenium + Gradle**.

El objetivo de este nivel es demostrar una automatización de nivel medio mediante el manejo de **contextos especiales 
del DOM**, implementando interacciones sobre `iframe` y `shadow root` con validaciones básicas.

## 🎯 Objetivo del ejercicio

Implementar pruebas automatizadas que permitan:

- abrir una página con estructuras especiales del DOM
- cambiar correctamente al contexto de un `iframe`
- acceder correctamente a un `shadow root`
- validar que la interacción en ambos casos sea exitosa

## 🧩 Tecnologías usadas

- **Java 17** ☕
- **Gradle** 🛠️
- **SerenityBDD** 📊
- **Cucumber** 🥒
- **Selenium WebDriver** 🌐
- **AssertJ** ✅

## 📝 Escenarios implementados

### **Feature:** Manejo de contextos especiales del DOM

### **Scenario:** Interactuar con un iframe

- que el usuario abre la página de iframe
- cambia al iframe configurado
- la interacción con iframe debe ser exitosa

### **Scenario:** Interactuar con un shadow root

- que el usuario abre la página de shadow root
- accede al shadow root configurado
- la interacción con shadow root debe ser exitosa

## 📄 Datos de prueba

Los datos se consumen desde configuración o archivo de datos con valores como los siguientes:

```json
{
  "url": "https://selectorshub.com/iframe-scenario/",
  "iframeCss": "iframe"
}
```
## 📄 Datos usados

- `url`: página utilizada para la validación del escenario de iframe
- `iframeCss`: selector CSS utilizado para identificar el iframe

## 🏗️ PageObject implementado

Se implementaron `PageObject` para encapsular la lógica de interacción con elementos en contextos especiales del DOM, 
incluyendo:

- apertura de páginas de prueba
- acceso al `iframe`
- cambio de contexto al `iframe`
- acceso al `shadow root`
- interacción con elementos internos
- validaciones básicas del resultado esperado

Esto permite mantener una automatización más limpia, reutilizable y escalable. ✅

## 🧱 Enfoque del nivel intermediate

Este nivel demuestra una automatización más estructurada que un flujo básico, incorporando:

- manejo de contextos especiales del DOM
- uso de `PageObject` en SerenityBDD
- separación de responsabilidades
- validaciones funcionales básicas
- mejor mantenibilidad de la solución

## ▶️ Ejecución

Desde la raíz del proyecto:

```bash
gradlew clean test
```
## 📊 Reportería

El reporte de Serenity se genera en:

`target/site/serenity/index.html`

## ⚙️ Configuración

El proyecto utiliza los siguientes archivos principales de configuración:

- `build.gradle`
- `serenity.conf`
- `serenity.properties`

Estos archivos permiten definir dependencias, configuración de ejecución y comportamiento general de SerenityBDD.

## ✅ Qué demuestra este branch

- implementación de `PageObject` en SerenityBDD
- automatización de escenarios con Cucumber
- manejo de `iframe`
- manejo de `shadow root`
- validaciones básicas sobre contextos especiales del DOM
- uso de datos de prueba configurables
- reportería automática con Serenity

## 👨‍💻 Resultado

Este branch representa el nivel **intermediate** de la prueba técnica, 
enfocado en el manejo de contextos especiales del DOM mediante una automatización estructurada, 
clara y alineada con buenas prácticas. 🎉