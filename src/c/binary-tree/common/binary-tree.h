/**
 * FileName:   binary-tree.h
 * Author:     Fasion Chan
 * @contact:   fasionchan@gmail.com
 * @version:   $Id$
 *
 * Description:
 *
 * Changelog:
 *
 **/

#ifndef _BINARY_TREE_H_
#define _BINARY_TREE_H_

struct binary_tree_node {
    struct binary_tree_node *left, *right;
    int value;
};

#endif
