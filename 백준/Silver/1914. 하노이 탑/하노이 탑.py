def hanoi(count, from_peg, to_peg, temp_peg):
    if count == 1:
        moves.append(f"{from_peg} {to_peg}")
        return
    
    hanoi(count - 1, from_peg, temp_peg, to_peg)
    moves.append(f"{from_peg} {to_peg}")
    hanoi(count - 1, temp_peg, to_peg, from_peg)

if __name__ == "__main__":
    count = int(input())
    moves = []
    print(2 ** count - 1)
    
    if count <= 20:
        hanoi(count, 1, 3, 2)
        print("\n".join(moves))
