from django.http import HttpResponse
from django.shortcuts import render

def home(requests):

	return render(requests, 'home.html')

def niit(requests):

	return HttpResponse('<h1> Hello World </h1>')

def count(request):
	data = request.GET['full']
	listx = data.split()
	return render(request, 'count.html', { 'dataone':data, 'len':len(listx)})
