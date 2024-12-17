package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(firstUniqChar("uddrr"))
}
func firstUniqChar(s string) int {
	count := 0
	for index, char := range s {
		count = strings.Count(s, string(char))
		if count > 1 {
			continue
		} else {
			return index
		}
	}
	return -1
}
