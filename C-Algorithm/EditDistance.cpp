
// ######################################################################## //
//
//  本程序使用动态规划法解决 '编辑距离' 问题.
//
//  创建日期: 2016-04-03
//
//  修改记录:
//  ( 1 ) 2016-04-03 创建了初始版本( v0.10 )
//
//  版 本 号: v0.10
//
//  备    注: 使用标准 C 代码实现
//
//  作    者: 刘伟
//
// ######################################################################## //

// EditDistance.cpp : 定义控制台应用程序的入口点。
//


// 使用的库定义
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// ######################################################################## //
//                                                                          // 
//                              下面是数据定义区                               // 
//                                                                          // 
// ######################################################################## //

#define STR_LEN           100
#define TRUE              1
#define FALSE             0
#define MAX_STACK_LEVEL   100 // 栈的最大层次

// 二叉树中孩子结点类型 ...
enum EditActionType
{
  eaIns, // 插入操作 ...
  eaRep, // 替换操作 ...
  eaDel  // 删除操作 ...
};

// 下面是处理计算编辑距离操作时的代码 ...
typedef struct
{
  EditActionType EditAction;
  int            i, j; // 编辑距离操作, 将 A[ i ] -> B[ j ] ...
}EditActionNode;

// 顺序栈( 编辑距离操作 )的结构体类型定义 ...
typedef struct
{
  EditActionNode Elem[ MAX_STACK_LEVEL ];
  int            Top;
}SeqEditActionStack;

//////////////////////////////////////////////////////////////////////////////


// ######################################################################## //
//                                                                          // 
//                           下面是各个子函数定义                               // 
//                                                                          // 
// ######################################################################## //

// 顺序栈( 编辑距离操作 )的操作及实现 ...
void InitStack( SeqEditActionStack *S );
int  IsStackEmpty( SeqEditActionStack *S );
int  IsStackFull( SeqEditActionStack *S );
int  PushStack( SeqEditActionStack *S, EditActionNode x );
int  PopStack( SeqEditActionStack *S, EditActionNode *x );

int  FindTripleMin( int a, int b, int c );
int  FindTripleMinLocation( int a, int b, int c );
void PrintSubString( char *s, int i, int j );
int  CalcEditDistance( char *StrA, char *StrB, int **d );
void PrintEditDistanceMatrix( int **d, int RowNum, int ColNum );
void DisplayEditAction( char *StrA, char *StrB, int **d );

//////////////////////////////////////////////////////////////////////////////

// ######################################################################## //
//                                                                          // 
//                      下面是顺序栈( 字符型 )的操作及实现                        // 
//                                                                          // 
// ######################################################################## //

// 栈初始化 ...
void InitStack( SeqEditActionStack *S )
{
  S -> Top = -1;
}

// 栈是否为空 ...
int IsStackEmpty( SeqEditActionStack *S )
{
  return ( S -> Top == -1 );
}

// 栈是否为满 ...
int IsStackFull( SeqEditActionStack *S )
{
  return ( S -> Top == ( MAX_STACK_LEVEL - 1 ) );
}

// 入栈 ...
int PushStack( SeqEditActionStack *S, EditActionNode x )
{
  if ( IsStackFull( S ) )
    return FALSE;

  S -> Top++;
  S -> Elem[ S -> Top ] = x;
  return TRUE;
}

// 出栈 ...
int PopStack( SeqEditActionStack *S, EditActionNode *x )
{
  if ( IsStackEmpty( S ) )
    return FALSE;

  *x = S -> Elem[ S -> Top ];
  S -> Top--;
  return TRUE;
}

// ######################################################################## //
//                                                                          // 
//                          下面是各个子函数的实现                             // 
//                                                                          // 
// ######################################################################## //

// 取 3 个整数中的最小值 ...
int FindTripleMin( int a, int b, int c )
{
  int t = ( a < b ) ? a : b;

  return ( ( t < c ) ? t : c );
}

// 取 3 个整数中的最小值的位置 ...
// ( 按照下图的位置返回最小值的位置 '0' - '2' )
//
// 'a' -> 0
// 'b' -> 1
// 'c' -> 2
//
// b( 1 )   c( 2 )
//
//
// a( 0 )   X
int FindTripleMinLocation( int a, int b, int c )
{
  int t;

  t = FindTripleMin( a, b, c );
  if ( t == a )
    return 0;
  else if ( t == b )
	return 1;
  else
    return 2;
}

// 打印字符串 's' 的第 'i' ~ 第 'j' 个字符 ...
// ( 传入的 'i', 'j' 坐标基于 '1' )
void PrintSubString( char *s, int i, int j )
{
  int k;

  for ( k = i - 1; k <= j - 1; k++ )
    if ( k < strlen( s ) )
      printf( "%c", s[ k ] );
}

// 使用动态规划法计算两个字符串之间的编辑距离 ...
//
// 测试数据如下 :
// ( 1 ) A = fxpimu  B = xwrs  d( A, B ) = 5
// ( 2 ) A = abc     B = cba   d( A, B ) = 2
// ( 3 ) A = stot    B = stop  d( A, B ) = 1
// ( 4 ) A = cd      B = abcb  d( A, B ) = 3
int CalcEditDistance( char *StrA, char *StrB, int **d )
{
  // 初始化距离矩阵 ...
  for( int i = 0; i <= strlen( StrA ); i++ )
    d[ i ][ 0 ] = i;

  for( int j = 0; j <= strlen( StrB ); j++ )
    d[ 0 ][ j ] = j;

  // 请将下面的代码补充完毕, 使程序可以正确运行 ...
  // ......
  
  for (int i = 1; i <= strlen(StrA); i++ ) {
  	for (int j = 1; j <= strlen(StrB); j++ ) {
  		if (StrA[i - 1] == StrB[j - 1]) {
  			d[i][j] = d[i - 1][j - 1];
		} else {
		  int min = FindTripleMin(d[i][j - 1], d[i - 1][j - 1], d[i - 1][j]);
		  d[i][j] = min + 1;
  	  }
    }
  }
 
  // 返回编辑距离值 ...
  return d[ strlen( StrA ) ][ strlen( StrB ) ];
}

// 打印编辑距离矩阵 ...
void PrintEditDistanceMatrix( int **d, int RowNum, int ColNum )
{
  int i, j;

  printf( "\t生成的编辑距离矩阵为 : \n" );
  for ( i = 0; i <= RowNum - 1; i++ )
  {
     printf( "\t" );
	 for ( j = 0; j <= ColNum - 1; j++ )
       printf( "%d ", d[ i ][ j ] );
	 printf( "\n" );
  }
  printf( "\n\n" );
}

// 显示将字符串 'StrA' 转换为字符串 'StrB' 的具体操作步骤 ...
void DisplayEditAction( char *StrA, char *StrB, int **d )
{
  SeqEditActionStack EditActionStack;
  EditActionNode     EANode;
  int i, j, k, t;

  printf( "\t\n\n***********************************\n" );
  printf( "\t字符串 A -> %s\n", StrA );
  printf( "\t字符串 B -> %s\n", StrB );
  printf( "\t编辑操作步骤为 :\n\n" );
  
  // 栈初始化 ...
  InitStack( &EditActionStack );

  // 得到字符串的长度 ...
  i = strlen( StrA ); // 'm' 值 ...
  j = strlen( StrB ); // 'n' 值 ...

  // 从 d[ m ][ n ] 开始 '倒推' 处理 ...
  // ( d[ m ][ n ] 表示将 'StrA' -> 'StrB' 的编辑距离值, 总共压栈 'd[ m ][ n ]' 个节点 )
  for( k = 1; k <= d[ strlen( StrA ) ][ strlen( StrB ) ]; k++ )
  {
	
	//处理左上边界 
	//1 插入 2换 3删除 
	if (j == 0) {
		EANode.EditAction = EditActionType(2);
		EANode.i = i;
		EANode.j = j;
		PushStack( &EditActionStack, EANode );
		i-=1;
		continue;
	}
	if (i == 0) {
		EANode.EditAction = EditActionType(0);
		EANode.i = i;
		EANode.j = j;
		PushStack( &EditActionStack, EANode );
		j-=1;
		continue;	
	} 
	//处理相等情况 
	if (d[i - 1][j - 1] == d[i][j] && StrA[i - 1] == StrB[j - 1]) {
		k--;
		i-=1;
		j-=1;
		continue;
	}
	
	// 得到操作步骤( 最小值 ) ...
    // 取 3 个整数中的最小值的位置 ...
    t = FindTripleMinLocation( d[ i ][ j - 1 ], d[ i - 1 ][ j - 1 ], d[ i - 1 ][ j ] );
	

	// 记录操作类型 ...
	EANode.EditAction = EditActionType( t );

	// 压栈 ...
	EANode.i = i;
	EANode.j = j;
	PushStack( &EditActionStack, EANode );

	// 修改 'i', 'j' 位置 ...
    switch( EANode.EditAction )
    {
      case eaIns : { i = i;     j = j - 1; break; } // '插入' 操作 ...
      case eaRep : { i = i - 1; j = j - 1; break; } // '替换' 操作 ...
      case eaDel : { i = i - 1; j = j;     break; } // '删除' 操作 ...
    }
  }

  // 输出编辑操作 ...
  // ( 弹栈过程 )
  while ( !IsStackEmpty( &EditActionStack ) )
  {
	// 弹栈 ...
	PopStack( &EditActionStack, &EANode );

	// 根据不同编辑操作进行相应处理 ...
    switch( EANode.EditAction )
    {
      case eaIns : {  
		             // '插入' 操作 ...
		             // 将 Ai -> Bj-1, 再插入 B[ j ] ...
		             printf( "\t" );
		             PrintSubString( StrA, 1, EANode.i );
					 printf( " -> " );
					 PrintSubString( StrB, 1, EANode.j );
					 printf( "        插入 %c ", StrB[ EANode.j - 1 ] );
					 printf( "\n" );

				     break;
  			       } 
      case eaRep : {
		             // '替换' 操作 ...
		             // 将 Ai-1 -> Bj-1, 再将 A[ i ] 替换为 B[ j ] ...

                     // 请将下面的代码补充完毕, 使程序可以正确运行 ...
                     // ......
                     printf( "\t" );
		             PrintSubString( StrA, 1, EANode.i );
					 printf( " -> " );
					 PrintSubString( StrB, 1, EANode.j );
					 printf( "        %c 替换 %c ", StrA[EANode.i - 1], StrB[ EANode.j - 1 ] );
					 printf( "\n" );

                     break;
 			       }
      case eaDel : {
		             // '删除' 操作 ...
		             // 将 Ai 末尾字符 A[ i ] 删除, 再将 Ai-1 -> Bj ...
		             printf( "\t" );
		             PrintSubString( StrA, 1, EANode.i );
					 printf( " -> " );
					 PrintSubString( StrB, 1, EANode.j );
                     printf( "        删除 %c ", StrA[ EANode.i - 1 ] );
					 printf( "\n" );

                     break;
 			       }
    }
  }
}

//////////////////////////////////////////////////////////////////////////////

// ######################################################################## //
//                                                                          // 
//                             下面是主程序的实现                              // 
//                                                                          // 
// ######################################################################## //

int main(void)
{
  char StrA[ STR_LEN ];
  char StrB[ STR_LEN ];
  int  **d;
  int  i, m, n, dAB;
  int  IsStop;

  IsStop = FALSE;
  while ( !IsStop )
  {
    // 清屏 ...
    system( "cls" );

	// 输入字符串 'A' ...
    printf( "\n\n\t请输入 < 字符串 A > ， 输入 < q / Q > 表示结束 : " );
    scanf( "%s", StrA );
	m = strlen( StrA );
    if ( m > 0 )
	  IsStop = ( ( StrA[ 0 ] == 'q' ) || ( StrA[ 0 ] == 'Q' ) );
    else
      printf( "\t输入的字符串 A 不能为空 !\n\n" );

	if ( !IsStop )
	{
	  // 输入字符串 'B' ...
      printf( "\n\t请输入 < 字符串 B > ， 输入 < q / Q > 表示结束 : " );
      scanf( "%s", StrB );
      n = strlen( StrB );
      if ( n > 0 )
	    IsStop = ( ( StrB[ 0 ] == 'q' ) || ( StrB[ 0 ] == 'Q' ) );
      else
        printf( "\t输入的字符串 B 不能为空 !\n\n" );

	  // 输入的字符串 'A' 和 'B' 均不为空, 则计算其编辑距离 ...
	  if ( !IsStop )
	  {
        // 动态申请二维数组 ...
        d = ( int ** )malloc( ( m + 1 ) * sizeof( int ) );
        for ( i = 0; i <= m; i++ )
          d[ i ] = ( int * )malloc( ( n + 1 ) * sizeof( int ) );

        // 计算编辑距离 ...
        dAB = CalcEditDistance( StrA, StrB, d );

        // 显示计算结果 ...
        printf( "\n\t< 字符串 A 和 B 之间的编辑距离为：%d > \n\n", dAB );

		// 打印编辑距离矩阵 ...
		PrintEditDistanceMatrix( d, ( m + 1 ), ( n + 1 ) );

        // 显示将字符串 'StrA' 转换为字符串 'StrB' 的具体操作步骤 ...
        DisplayEditAction( StrA, StrB, d );

        // 释放空间 ...
        for ( i = 0; i <= m; i++ )
          free( d[i] );
        free(d);


        // 等待用户输入任意一键返回 ...
        printf( "\n\n" );
        system( "PAUSE" );
//        IsStop = true;
	  }
	}
  }

  // 等待用户输入任意一键返回 ...
  printf( "\n\n" );
  system( "PAUSE" );
}

//////////////////////////////////////////////////////////////////////////////
