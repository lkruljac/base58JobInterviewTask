using Common;
using Models;
using Services;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Threading;

namespace ViewModels
{
    public class FrontPageViewModel : BasePageViewModel
    {

        public FrontPageViewModel(MainWindowViewModel ownerWindow) : base(ownerWindow)
        {

        }

        public override void EnterPage()
        {
            new Thread(() =>
            {
                while (true)
                {
                    Dispatcher.CurrentDispatcher.Invoke(() =>
                    {
                        ServiceStatus = TickerAPIWrapper.IsServiceOnline() ? "Online" : "Offline";
                    });
                }
            }).Start();
        }

        private string _ServiceStatus;
        public string ServiceStatus
        {
            get { return _ServiceStatus; }
            set { _ServiceStatus = value; RaisePropertyChangedEvent("ServiceStatus"); }
        }

        private ObservableCollection<Ticker> _Tickers;
        public ObservableCollection<Ticker> Tickers
        {
            get { return _Tickers; }
            set { _Tickers = value; RaisePropertyChangedEvent("Tickers"); }
        }

        private string _PairName;

        public string PairName
        {
            get { return _PairName; }
            set { _PairName = value; RaisePropertyChangedEvent("PairName"); }
        }

        private string _Date;
        public string Date
        {
            get { return _Date; }
            set { _Date = value; RaisePropertyChangedEvent("Date"); }
        }

        private DelegateCommand _ListCommand;
        public DelegateCommand ListCommand
        {
            get 
            {
                if(_ListCommand == null)
                {
                    _ListCommand = new DelegateCommand(new Action(List));
                }
                return _ListCommand; 
            }
            set { _ListCommand = value; }
        }

        public void List() 
        {
            
            try
            {
                if(Date != string.Empty && PairName != string.Empty)
                {
                    Tickers = TickerAPIWrapper.GetTickers(Date, PairName);
                }
                else if(PairName != string.Empty) 
                {
                    Tickers = TickerAPIWrapper.GetTickers(PairName);
                }
                else
                {
                    Tickers = TickerAPIWrapper.GetTickers();
                }
            
            }
            catch
            {
                MessageBox.Show("Something went wrong, check service status", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

    }
}
