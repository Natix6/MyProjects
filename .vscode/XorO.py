
mylists = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Xturn = True
Xwon = False
Ywon = False
meow = 1

def makeTurn(Xturn):

    if Xturn == True:
        rowX =   int(input("It's X turn, enter a row:"))
        lineX = int(input("It's X turn, enter a line:"))
        mylists[lineX][rowX] = 'X'
    else:
        rowY =  int(input("It's Y turn, enter a row:"))
        lineY = int(input("It's Y turn, enter a line:")) 
        mylists[lineY][rowY] = 'Y'

    
def whoWins():

    for i in range(3):
        if((mylists[i])[0]) == ((mylists[i])[1]) == ((mylists[i])[2]):
            return True
        elif((mylists[0])[i]) == ((mylists[1])[i]) == ((mylists[2])[i]):
            return True
        
    return False
    

while Ywon != True and Xwon != True:
    
    if meow % 2 == 0:
        Xturn = False
    else:
        Xturn = True

    makeTurn(Xturn)
    
    if whoWins():
        if(Xturn):
            Xwon = True
        else:
            Ywon = True

    meow = meow + 1

if Ywon == True:
    print("Y won")
else:
    print("X won")


