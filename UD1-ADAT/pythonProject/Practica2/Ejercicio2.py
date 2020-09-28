import csv
import sys

csvBase= open("Datos_Olimpiadas/athlete_events.csv")
reader = csv.reader(csvBase)


csvDestino= open("Datos_Olimpiadas/olimpiadas.csv", "w")
writer = csv.writer(csvDestino)
writer.writerow(('Games', 'Year', 'Season', 'City'))
for row in reader:
    print(row)
    writer.writerow(row(8),row(9),row(10),row(11))

