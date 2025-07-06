# Compilador para JS-- (Procesadores de Lenguajes)

Este repositorio contiene el desarrollo de un compilador para el lenguaje **JS--**, realizado como parte de la asignatura **Procesadores de Lenguajes** del Grado en Ingeniería Informática en la **Universidad Politécnica de Madrid (UPM)**.

## 📚 Descripción del Proyecto

Se ha implementado un compilador en **Java** para un lenguaje educativo denominado **JS--**, que incluye:

- 🔍 Un **analizador léxico** para el reconocimiento de tokens.
- 🧠 Un **analizador sintáctico** descendente con tablas para validar la estructura gramatical.
- ✅ Un **analizador semántico** básico para la verificación de tipos, ámbitos y uso correcto de identificadores.

El lenguaje JS-- está inspirado en JavaScript, con una gramática definida y un conjunto limitado de características, orientado a prácticas de análisis y compilación.

## ✨ Características del Lenguaje Implementadas

### Parte común obligatoria (para todos los grupos):

- ✅ Estructura general de un programa compuesto por funciones y declaraciones.
- ✅ Definición de funciones.
- ✅ Tipos de datos: `int`, `boolean`, `string`, `void`.
- ✅ Variables y su declaración explícita.
- ✅ Constantes: enteras y cadenas de caracteres.
- ✅ Sentencias:
  - Asignación (`=`)
  - Condicional simple (`if`)
  - Llamada a funciones
  - Retorno (`return`)
  - Entrada/salida por terminal (`input`, `output`)
- ✅ Expresiones aritméticas, lógicas y relacionales.
- ✅ Comentarios.
- ✅ Operadores (mínimo uno por tipo):
  - Aritméticos: `+`, `-`, `*`, `/`, `%`
  - Relacionales: `==`, `!=`, `<`, `>`, `<=`, `>=`
  - Lógicos: `&&`, `||`, `!`

### Parte específica del grupo:

- ✅ Sentencias condicionales compuestas: `if`, `if-else`
- ✅ Operadores especiales: post-incremento (`id++`)
- ✅ Comentarios de línea: `// comentario`
- ✅ Cadenas de caracteres delimitadas con comillas dobles (`"texto"`)

## 🛠️ Tecnologías y técnicas utilizadas

- Lenguaje de implementación: **Java**
- Técnicas de análisis:
  - Léxico: análisis manual mediante clases Java
  - Sintáctico: **análisis descendente con tablas**
  - Semántico: comprobaciones de tipos y ámbito

## 👨‍🎓 Autor

**Rodrigo Lomba Moreno**  
Estudiante de Ingeniería Informática  
[Universidad Politécnica de Madrid](https://www.upm.es)

🔗 [Perfil de GitHub](https://github.com/rlombamoreno)

---
