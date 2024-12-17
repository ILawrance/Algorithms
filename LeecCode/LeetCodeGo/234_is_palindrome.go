package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	node := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: nil}}
	isPalindrome(node)
}

func isPalindrome(head *ListNode) bool {
	return false
}
