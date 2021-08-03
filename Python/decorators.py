# decorators.py

# Just important attributes of object(function "add" in this case)
    # add   : physical memory address of function
    # add.__module__: defined in which module
    # add.__defaults__: what default values it had
    # add.__code__.co_code: byte code for this add function
    # add.__code__.co_nlocals: how many local variables the function has
    # add.__code__.co_name: name of the function
    # add.__code__.co_varnames: names of the variables

# More Interesting questions that can be asked from object
    # Get function source code
        # from inspect import getsource
        # getsource(add)
        # print(getsource(add))
    # Get function file name
        # from inspect import getfile
        # getfile(add)

from time import time

# Wrapper to calculate the time elapsed when the wrapper function is called
def timer(func):
    def f(*args, **kwargs):
        # *args      : arguments without key values
        # **kwargs   : arguments with key values e.g. y=10 instead of just 10    
        before = time()
        rv = func(*args, **kwargs)
        after = time()
        print('elapsed: ', after - before)
        return rv
    return f

# @timer is same as "add = timer(sub)", here timer is a wrapper function
# which adds to the functionality of add function
# Same goes for the subtract function below
@timer
def add(x, y=10):
    return x + y

@timer
def sub(x, y=10):
    return x - y

print('add(10)',        add(10))
print('add(20, 30)',    add(20, 30))
print('add("a", "b")',  add("a", "b"))   
print('add(10)',        sub(10))
print('add(20, 30)',    sub(20, 30))

# Now lets say we want a wrapper to run function n times (just an example)
def ntimes(n):
    def inner(f):
        def wrapper(*args, **kwargs):
            for _ in range(n):
                print('running {.__name__}'.format(f))
                rv = f(*args, **kwargs)
            return rv
        return wrapper
    return inner

@ntimes(4) # where 4 is the number of times we want add1 to run
def add1(x, y=10):
    return x + y

print('add1(10)',        add1(10))


