# Como Trabajar con Ramas
## 1. Preparar tu repositorio local
Antes de empezar, asegúrate de que tu versión local de main esté al día.
```
git checkout main
git pull origin main
```
## 2. Crear una nueva rama
Nunca trabajes sobre main. Crea una rama con un nombre descriptivo de la tarea.
```
git checkout -b nombre-de-tu-rama
```
*Ejemplo:*```git checkout -b fix-login-error```
## 3. Hacer tus cambios y subirlos
Trabaja en tu código normalmente, haz commits y luego sube esa rama específica a GitHub.
```
git add .
git commit -m "Descripción de lo que hiciste"
git push origin nombre-de-tu-rama
```
## 4. Crear el Pull Request (PR)
Ahora ve a la web de GitHub:
1. Verás un cartel amarillo que dice "Compare & pull request". Haz clic ahí.
2. Escribe un título y una descripción de tus cambios.
3. Asigna a "Reviewers" (compañeros) para que revisen tu código.
4. Haz clic en "Create pull request".
## 5. Revisión y Mezcla (Merge)
Una vez abierto el PR:
* Feedback: Tus compañeros pueden dejar comentarios o pedir cambios.
* Aprobación: Cuando alguien apruebe (Approve), aparecerá un botón verde.
* Merge: Haz clic en "Merge pull request". Esto pasará tus cambios de tu rama a main.
## 6. Limpieza
Después de fusionar, borra la rama para mantener el proyecto limpio.
* En GitHub: Clic en "Delete branch".
* *En tu PC: ```git branch -d nombre-de-tu-rama```.