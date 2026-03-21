# menu de opciones
books = []
users = []

def show():
    print("Biblioteca Virtual")
    print("1. Agregar libro")
    print("2. Agregar usuario")
    print("3. Mostrar libros")
    print("4. Mostrar usuarios")
    print("5. Salir")
    
def add_book():
    title = input("Ingrese el titulo del libro: ")
    author = input("Ingrese el autor del libro: ")
    book = {"id": len(books) + 1, "title": title, "author": author}
    books.append(book)
    print(f"Libro {title} agregado exitosamente")
    
def add_user():
    name = input("Ingrese el nombre del usuario: ")
    email = input("Ingrese el correo electrónico del usuario: ")
    user = {"id": len(users) + 1, "name": name, "email": email}
    users.append(user)
    print(f"Usuario {name} agregado exitosamente")
    
def show_books():
    if len(books) == 0:
        print("No hay libros registrados")
    else:
        print("Libros registrados:")
        for book in books:
            print(f"ID: {book['id']}, Título: {book['title']}, Autor: {book['author']}")

def show_users():
    if len(users) == 0:
        print("No hay usuarios registrados")
    else:
        print("Usuarios registrados:")
        for user in users:
            print(f"ID: {user['id']}, Nombre: {user['name']}, Email: {user['email']}")
    
def find_user(user_id):
    user = next((user for user in users if user["id"] == user_id), None)
    return user

def find_book(book_id):
    book = next((book for book in books if book["id"] == book_id), None)
    return book

while True:
    show()
    option = input("Ingrese una opción: ")
    print(f"La opción seleccionada es {option}")

    if option == "1":
        add_book();
    elif option == "2":
        add_user();
    elif option == "3":
        show_books();
    elif option == "4":
        show_users();
    elif option == "5":
        print("Saliendo del programa...")
        break
    else:
        print("Opción no válida, por favor ingrese una opción del 1 al 5")