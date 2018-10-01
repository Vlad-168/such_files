text = "Gaudeamus igitur,Juvenes dum sumus!Post jucundam juventutem,Post molestam senectutemNos habebit humus!Ubi sunt, qui ante nosIn mundo fuere?Transeas ad superos, Transeas ad inferos,Hos si vis videre!!Vita nostra brevis est,Brevi finietur.Venit mors velociter,Rapit nos atrociter,Nemini parcetur!Vivat Academia!Vivant professores!Vivat membrum quodlibet!Vivant membra quaelibet!Semper sint in flore!Vivant omnes virginesGraciles, formosae!Vivant et mulieresTenerae, amabiles,Bonae, laboriosae!Vivat et res publicaEt qui illam regunt!Vivat nostra civitas,Maecenatum caritas,Qui nos hic protegunt!Pereat tristitia,Pereant doloresPereat Diabolus,Quivis antiburschiusAtque irrisores!"
print(text.lower())
text = text.lower()
d = dict.fromkeys(text, 0)
for c in text: d[c] += 1
inverse = [(value, key) for key, value in d.items()]
print (max(inverse)[1])
print(d['e'])

	