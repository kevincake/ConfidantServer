#!/usr/bin/python
import sys,os
f=open('hi.txt','r+')
flist=f.readlines()
flist[4]='hi\n'
f=open('hi.txt','w+')
f.writelines(flist)