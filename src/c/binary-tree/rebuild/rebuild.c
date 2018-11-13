/**
 * FileName:   rebuild.c
 * Author:     Fasion Chan
 * @contact:   fasionchan@gmail.com
 * @version:   $Id$
 *
 * Description:
 *
 * Changelog:
 *
 **/

#include <stdio.h>
#include <stdlib.h>

#include "../common/binary-tree.h"


/**
 * postorder traversal a binary tree
 **/
void
postorder_traversal(struct binary_tree_node *root,
    void handler(struct binary_tree_node *))
{
    if (root == NULL) {
        return;
    }

    if (root->left) {
        postorder_traversal(root->left, handler);
    }
    if (root->right) {
        postorder_traversal(root->right, handler);
    }

    handler(root);
}


/**
 * destroy binary and free memory back to system
 **/
void
free_tree(struct binary_tree_node *root)
{
    postorder_traversal(root, (void (*)(struct binary_tree_node *))free);
}


/**
 * rebuild binary tree from inorder and preorder sequence
 **/
struct binary_tree_node *
rebuild_binary_tree_pre(int n, int inOrderSeq[], int preOrderSeq[])
{
    // root value
    int value = preOrderSeq[0];

    // count left subtree nodes
    int lefts = n;
    for (int i=0; i<n; i++) {
        if (inOrderSeq[i] == value) {
            lefts = i;
            break;
        }
    }

    // bad seq
    if (lefts == n) {
        return NULL;
    }

    // calculate right subtree nodes
    int rights = n - 1 - lefts;

    struct binary_tree_node *left = NULL;
    struct binary_tree_node *right = NULL;

    // rebuild left subtree recursively
    if (lefts > 0) {
        left = rebuild_binary_tree_pre(lefts, inOrderSeq, preOrderSeq+1);
        if (left == NULL) {
            return NULL;
        }
    }

    // rebuild left subtree recursively
    if (rights > 0) {
        right = rebuild_binary_tree_pre(rights, inOrderSeq+lefts+1, preOrderSeq+lefts+1);
        if (right == NULL) {
            free_tree(left);
            return NULL;
        }
    }

    // allocate memory for root node
    struct binary_tree_node *root = (struct binary_tree_node *)malloc(sizeof(struct binary_tree_node));
    if (root == NULL) {
        free_tree(left);
        free_tree(right);
        return NULL;
    }

    // set root node fields
    root->value = value;
    root->left= left;
    root->right = right;

    return root;
}


/**
 * print tree node value
 **/
void
print_node_value(struct binary_tree_node *node)
{
    printf("%d ", node->value);
}


int
main()
{
    int inOrderSeq[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int preOrderSeq[] = {6, 5, 2, 1, 4, 3, 8, 7, 12, 10, 9, 11};

    // rebuild binary tree
    struct binary_tree_node *root = rebuild_binary_tree_pre(12, inOrderSeq, preOrderSeq);

    // postorder traversal binary tree and print node value
    postorder_traversal(root, print_node_value);

    // free binary tree
    free_tree(root);
}
