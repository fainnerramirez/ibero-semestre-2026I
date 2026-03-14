list = [1,2,3, "Fainner"]
print(list)

list.append("Python") # agrega elemento al final de la lista
print(list)

list.insert(1, "Hola") # inserta un elemento en la posición indicada, desplazando los elementos a la derecha
print(list)

list.pop() # elimina el último elemento de la lista
print(list)

list.pop(0) # elimina el elemento en la posición indicada
print(list)

#list.clear() # elimina todos los elementos de la lista
#print(list)

list2 = [4,5,6]
list.extend(list2) # agrega los elementos de otra lista al final de la lista
print(list)

index = list.index("Fainner") # devuelve el índice del primer elemento que coincide con el valor indicado
print(f"El índice de 'Fainner' es {index}")

# condiciones con listas

if 6 in list:
    print("El número 6 está en la lista")
else:
    print("El número 6 no está en la lista")

#iterando una lista

for elemento in list:
    print(f"El elemento es {elemento}")
    
lista_numeros = [1,2,3,4,5]
cuadrados = [x**2 for x in lista_numeros] # lista por comprensión, crea una nueva lista con los cuadrados de los números del 0 al 9
print(cuadrados)

suma = sum(lista_numeros) # suma todos los elementos de la lista
print(f"La suma de los números es {suma}")

lenght = len(lista_numeros) # devuelve la cantidad de elementos de la lista
print(f"La cantidad de elementos de la lista es {lenght}")

promedio = suma / lenght # calcula el promedio de los números de la lista
print(f"El promedio de los números es {promedio:.2f}")
