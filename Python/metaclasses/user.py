# user.py
from library import Base

# A simple approach to make sure code does not screw on run time
# assert hasattr(Base, 'foo'), "you broke it, you fool!"

class Derived(Base):

    # If this method is not defined in the instance
    # of Derived class, an exception will be raised
    # by the meta class due to call __init_subclass__
    # For testing comment out this method and run
    def bar(self):
        return 'bar'
        