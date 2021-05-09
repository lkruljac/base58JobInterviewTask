using Common;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ViewModels
{
    public abstract class BasePageViewModel : BaseViewModel
    {
        protected MainWindowViewModel _owner;

        public BasePageViewModel(MainWindowViewModel ownerWindow)
        {
            _owner = ownerWindow;
        }
        public abstract void EnterPage();
    }
}
