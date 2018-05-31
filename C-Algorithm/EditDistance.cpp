
// ######################################################################## //
//
//  ������ʹ�ö�̬�滮����� '�༭����' ����.
//
//  ��������: 2016-04-03
//
//  �޸ļ�¼:
//  ( 1 ) 2016-04-03 �����˳�ʼ�汾( v0.10 )
//
//  �� �� ��: v0.10
//
//  ��    ע: ʹ�ñ�׼ C ����ʵ��
//
//  ��    ��: ��ΰ
//
// ######################################################################## //

// EditDistance.cpp : �������̨Ӧ�ó������ڵ㡣
//


// ʹ�õĿⶨ��
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// ######################################################################## //
//                                                                          // 
//                              ���������ݶ�����                               // 
//                                                                          // 
// ######################################################################## //

#define STR_LEN           100
#define TRUE              1
#define FALSE             0
#define MAX_STACK_LEVEL   100 // ջ�������

// �������к��ӽ������ ...
enum EditActionType
{
  eaIns, // ������� ...
  eaRep, // �滻���� ...
  eaDel  // ɾ������ ...
};

// �����Ǵ������༭�������ʱ�Ĵ��� ...
typedef struct
{
  EditActionType EditAction;
  int            i, j; // �༭�������, �� A[ i ] -> B[ j ] ...
}EditActionNode;

// ˳��ջ( �༭������� )�Ľṹ�����Ͷ��� ...
typedef struct
{
  EditActionNode Elem[ MAX_STACK_LEVEL ];
  int            Top;
}SeqEditActionStack;

//////////////////////////////////////////////////////////////////////////////


// ######################################################################## //
//                                                                          // 
//                           �����Ǹ����Ӻ�������                               // 
//                                                                          // 
// ######################################################################## //

// ˳��ջ( �༭������� )�Ĳ�����ʵ�� ...
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
//                      ������˳��ջ( �ַ��� )�Ĳ�����ʵ��                        // 
//                                                                          // 
// ######################################################################## //

// ջ��ʼ�� ...
void InitStack( SeqEditActionStack *S )
{
  S -> Top = -1;
}

// ջ�Ƿ�Ϊ�� ...
int IsStackEmpty( SeqEditActionStack *S )
{
  return ( S -> Top == -1 );
}

// ջ�Ƿ�Ϊ�� ...
int IsStackFull( SeqEditActionStack *S )
{
  return ( S -> Top == ( MAX_STACK_LEVEL - 1 ) );
}

// ��ջ ...
int PushStack( SeqEditActionStack *S, EditActionNode x )
{
  if ( IsStackFull( S ) )
    return FALSE;

  S -> Top++;
  S -> Elem[ S -> Top ] = x;
  return TRUE;
}

// ��ջ ...
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
//                          �����Ǹ����Ӻ�����ʵ��                             // 
//                                                                          // 
// ######################################################################## //

// ȡ 3 �������е���Сֵ ...
int FindTripleMin( int a, int b, int c )
{
  int t = ( a < b ) ? a : b;

  return ( ( t < c ) ? t : c );
}

// ȡ 3 �������е���Сֵ��λ�� ...
// ( ������ͼ��λ�÷�����Сֵ��λ�� '0' - '2' )
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

// ��ӡ�ַ��� 's' �ĵ� 'i' ~ �� 'j' ���ַ� ...
// ( ����� 'i', 'j' ������� '1' )
void PrintSubString( char *s, int i, int j )
{
  int k;

  for ( k = i - 1; k <= j - 1; k++ )
    if ( k < strlen( s ) )
      printf( "%c", s[ k ] );
}

// ʹ�ö�̬�滮�����������ַ���֮��ı༭���� ...
//
// ������������ :
// ( 1 ) A = fxpimu  B = xwrs  d( A, B ) = 5
// ( 2 ) A = abc     B = cba   d( A, B ) = 2
// ( 3 ) A = stot    B = stop  d( A, B ) = 1
// ( 4 ) A = cd      B = abcb  d( A, B ) = 3
int CalcEditDistance( char *StrA, char *StrB, int **d )
{
  // ��ʼ��������� ...
  for( int i = 0; i <= strlen( StrA ); i++ )
    d[ i ][ 0 ] = i;

  for( int j = 0; j <= strlen( StrB ); j++ )
    d[ 0 ][ j ] = j;

  // �뽫����Ĵ��벹�����, ʹ���������ȷ���� ...
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
 
  // ���ر༭����ֵ ...
  return d[ strlen( StrA ) ][ strlen( StrB ) ];
}

// ��ӡ�༭������� ...
void PrintEditDistanceMatrix( int **d, int RowNum, int ColNum )
{
  int i, j;

  printf( "\t���ɵı༭�������Ϊ : \n" );
  for ( i = 0; i <= RowNum - 1; i++ )
  {
     printf( "\t" );
	 for ( j = 0; j <= ColNum - 1; j++ )
       printf( "%d ", d[ i ][ j ] );
	 printf( "\n" );
  }
  printf( "\n\n" );
}

// ��ʾ���ַ��� 'StrA' ת��Ϊ�ַ��� 'StrB' �ľ���������� ...
void DisplayEditAction( char *StrA, char *StrB, int **d )
{
  SeqEditActionStack EditActionStack;
  EditActionNode     EANode;
  int i, j, k, t;

  printf( "\t\n\n***********************************\n" );
  printf( "\t�ַ��� A -> %s\n", StrA );
  printf( "\t�ַ��� B -> %s\n", StrB );
  printf( "\t�༭��������Ϊ :\n\n" );
  
  // ջ��ʼ�� ...
  InitStack( &EditActionStack );

  // �õ��ַ����ĳ��� ...
  i = strlen( StrA ); // 'm' ֵ ...
  j = strlen( StrB ); // 'n' ֵ ...

  // �� d[ m ][ n ] ��ʼ '����' ���� ...
  // ( d[ m ][ n ] ��ʾ�� 'StrA' -> 'StrB' �ı༭����ֵ, �ܹ�ѹջ 'd[ m ][ n ]' ���ڵ� )
  for( k = 1; k <= d[ strlen( StrA ) ][ strlen( StrB ) ]; k++ )
  {
	
	//�������ϱ߽� 
	//1 ���� 2�� 3ɾ�� 
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
	//���������� 
	if (d[i - 1][j - 1] == d[i][j] && StrA[i - 1] == StrB[j - 1]) {
		k--;
		i-=1;
		j-=1;
		continue;
	}
	
	// �õ���������( ��Сֵ ) ...
    // ȡ 3 �������е���Сֵ��λ�� ...
    t = FindTripleMinLocation( d[ i ][ j - 1 ], d[ i - 1 ][ j - 1 ], d[ i - 1 ][ j ] );
	

	// ��¼�������� ...
	EANode.EditAction = EditActionType( t );

	// ѹջ ...
	EANode.i = i;
	EANode.j = j;
	PushStack( &EditActionStack, EANode );

	// �޸� 'i', 'j' λ�� ...
    switch( EANode.EditAction )
    {
      case eaIns : { i = i;     j = j - 1; break; } // '����' ���� ...
      case eaRep : { i = i - 1; j = j - 1; break; } // '�滻' ���� ...
      case eaDel : { i = i - 1; j = j;     break; } // 'ɾ��' ���� ...
    }
  }

  // ����༭���� ...
  // ( ��ջ���� )
  while ( !IsStackEmpty( &EditActionStack ) )
  {
	// ��ջ ...
	PopStack( &EditActionStack, &EANode );

	// ���ݲ�ͬ�༭����������Ӧ���� ...
    switch( EANode.EditAction )
    {
      case eaIns : {  
		             // '����' ���� ...
		             // �� Ai -> Bj-1, �ٲ��� B[ j ] ...
		             printf( "\t" );
		             PrintSubString( StrA, 1, EANode.i );
					 printf( " -> " );
					 PrintSubString( StrB, 1, EANode.j );
					 printf( "        ���� %c ", StrB[ EANode.j - 1 ] );
					 printf( "\n" );

				     break;
  			       } 
      case eaRep : {
		             // '�滻' ���� ...
		             // �� Ai-1 -> Bj-1, �ٽ� A[ i ] �滻Ϊ B[ j ] ...

                     // �뽫����Ĵ��벹�����, ʹ���������ȷ���� ...
                     // ......
                     printf( "\t" );
		             PrintSubString( StrA, 1, EANode.i );
					 printf( " -> " );
					 PrintSubString( StrB, 1, EANode.j );
					 printf( "        %c �滻 %c ", StrA[EANode.i - 1], StrB[ EANode.j - 1 ] );
					 printf( "\n" );

                     break;
 			       }
      case eaDel : {
		             // 'ɾ��' ���� ...
		             // �� Ai ĩβ�ַ� A[ i ] ɾ��, �ٽ� Ai-1 -> Bj ...
		             printf( "\t" );
		             PrintSubString( StrA, 1, EANode.i );
					 printf( " -> " );
					 PrintSubString( StrB, 1, EANode.j );
                     printf( "        ɾ�� %c ", StrA[ EANode.i - 1 ] );
					 printf( "\n" );

                     break;
 			       }
    }
  }
}

//////////////////////////////////////////////////////////////////////////////

// ######################################################################## //
//                                                                          // 
//                             �������������ʵ��                              // 
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
    // ���� ...
    system( "cls" );

	// �����ַ��� 'A' ...
    printf( "\n\n\t������ < �ַ��� A > �� ���� < q / Q > ��ʾ���� : " );
    scanf( "%s", StrA );
	m = strlen( StrA );
    if ( m > 0 )
	  IsStop = ( ( StrA[ 0 ] == 'q' ) || ( StrA[ 0 ] == 'Q' ) );
    else
      printf( "\t������ַ��� A ����Ϊ�� !\n\n" );

	if ( !IsStop )
	{
	  // �����ַ��� 'B' ...
      printf( "\n\t������ < �ַ��� B > �� ���� < q / Q > ��ʾ���� : " );
      scanf( "%s", StrB );
      n = strlen( StrB );
      if ( n > 0 )
	    IsStop = ( ( StrB[ 0 ] == 'q' ) || ( StrB[ 0 ] == 'Q' ) );
      else
        printf( "\t������ַ��� B ����Ϊ�� !\n\n" );

	  // ������ַ��� 'A' �� 'B' ����Ϊ��, �������༭���� ...
	  if ( !IsStop )
	  {
        // ��̬�����ά���� ...
        d = ( int ** )malloc( ( m + 1 ) * sizeof( int ) );
        for ( i = 0; i <= m; i++ )
          d[ i ] = ( int * )malloc( ( n + 1 ) * sizeof( int ) );

        // ����༭���� ...
        dAB = CalcEditDistance( StrA, StrB, d );

        // ��ʾ������ ...
        printf( "\n\t< �ַ��� A �� B ֮��ı༭����Ϊ��%d > \n\n", dAB );

		// ��ӡ�༭������� ...
		PrintEditDistanceMatrix( d, ( m + 1 ), ( n + 1 ) );

        // ��ʾ���ַ��� 'StrA' ת��Ϊ�ַ��� 'StrB' �ľ���������� ...
        DisplayEditAction( StrA, StrB, d );

        // �ͷſռ� ...
        for ( i = 0; i <= m; i++ )
          free( d[i] );
        free(d);


        // �ȴ��û���������һ������ ...
        printf( "\n\n" );
        system( "PAUSE" );
//        IsStop = true;
	  }
	}
  }

  // �ȴ��û���������һ������ ...
  printf( "\n\n" );
  system( "PAUSE" );
}

//////////////////////////////////////////////////////////////////////////////
