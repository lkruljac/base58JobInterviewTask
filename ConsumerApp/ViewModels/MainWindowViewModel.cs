using Common;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace ViewModels
{
    public class MainWindowViewModel : BaseViewModel
    {

        public MainWindowViewModel(Window MainWindow)
        {
            Window = MainWindow;
            SelectedPage = new FrontPageViewModel(this);
            ((FrontPageViewModel)SelectedPage).EnterPage();
        }

        private Window _Window;
        public Window Window
        {
            get { return _Window; }
            set { _Window = value; }
        }

        private BaseViewModel _SelectedPage;
        public BaseViewModel SelectedPage
        {
            get { return _SelectedPage; }
            set 
            { 
                _SelectedPage = value;
                RaisePropertyChangedEvent("SelectedPage");
            }
        }

    }
}
